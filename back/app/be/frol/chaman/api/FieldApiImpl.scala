package be.frol.chaman.api

import be.frol.chaman.core.field.ConfigFieldTypes
import be.frol.chaman.mapper.FieldMapper
import be.frol.chaman.model.RichField
import be.frol.chaman.model.RichModelConversions._
import be.frol.chaman.openapi.api.FieldApi
import be.frol.chaman.openapi.model.{Field, FieldConfig}
import be.frol.chaman.service.{FieldDataService, FieldService}
import be.frol.chaman.tables
import be.frol.chaman.utils.OptionUtils.enrichedObject
import play.api.db.slick.DatabaseConfigProvider
import play.api.mvc.{AnyContent, ControllerComponents, Request}
import slick.dbio.DBIOAction

import javax.inject.Inject
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class FieldApiImpl @Inject()(
                              val cc: ControllerComponents,
                              val dbConfigProvider: DatabaseConfigProvider,
                              val fieldService: FieldService,
                              val fieldDataService: FieldDataService,
                            ) extends FieldApi with DbContext with ParentController {

  import api._


  /**
   * Get a field
   */
  def getField()(implicit request: Request[AnyContent]): Future[List[Field]] = run { implicit u =>
    db.run(
      for {
        fields <- fieldService.allFields
      } yield (fields.map(f => RichField(f, Nil)))
    ).map(_.map(FieldMapper.toDto(_)).toList)
  }



  /**
   * delete a field
   */
  override def deleteField(uuid: String)(implicit request: Request[AnyContent]): Future[Unit] = run { implicit u =>
    db.run(this.fieldService.delete(uuid))
      .map(_ => Unit)
  }


  override def createField(fieldConfig: FieldConfig)(implicit request: Request[AnyContent]): Future[Field] = run { implicit u =>
    db.run(
      fieldService.add(FieldMapper.toRow(fieldConfig, None)).flatMap { f =>
        fieldService.addValues(
          fieldConfig.config.getOrElse(Nil).flatMap(fc => FieldMapper.toDataRows(fc, f.uuid))
        ).map(v => RichField(f, Nil))
      }
    ).map(FieldMapper.toDto(_))
  }

  override def getFieldConfig(uuid: String)(implicit request: Request[AnyContent]): Future[FieldConfig] = {
    db.run(
      for {
        field <- fieldService.getField(uuid)
        config <- fieldDataService.dataFor(Seq(field.uuid)).result
      } yield FieldMapper.toConfigDto(field,config)
    )
  }


  override def updateField(uuid: String, fieldConfig: FieldConfig)(implicit request: Request[AnyContent]): Future[Field] = {

    run { implicit u =>
      val newField = FieldMapper.toRow(fieldConfig, uuid.toOpt())

      def updateIfNeeded(f: tables.Tables.FieldRow) = {
        if (!f.equivalent(newField)) fieldService.add(newField.field)
        else DBIOAction.successful(f)
      }

      db.run(
        for {
          f <- fieldService.getField(uuid)
          fd <- fieldDataService.dataFor(Seq(uuid)).result
          nf <- updateIfNeeded(f)
          nd <- fieldDataService.updateFieldValuesMaps(fd.toList.groupBy(_.fieldUuid),
            fieldConfig.config.getOrElse(Nil).flatMap(FieldMapper.toDataRows(_, uuid)).groupBy(_.fieldUuid))
        } yield (RichField(nf, nd))
      ).map(FieldMapper.toDto(_))
    }

  }
}
