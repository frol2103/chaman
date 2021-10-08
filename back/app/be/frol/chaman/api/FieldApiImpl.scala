package be.frol.chaman.api

import be.frol.chaman.mapper.FieldMapper
import be.frol.chaman.model.RichField
import be.frol.chaman.model.RichModelConversions._
import be.frol.chaman.openapi.api.FieldApi
import be.frol.chaman.openapi.model.Field
import be.frol.chaman.service.{FieldDataService, FieldService}
import be.frol.chaman.tables
import be.frol.chaman.utils.OptionUtils._
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
   * create a field
   */
  override def createField(field: Field)(implicit request: Request[AnyContent]): Future[Field] = run{ implicit u =>
    db.run(
      fieldService.add(FieldMapper.toRow(field)).flatMap { f =>
        fieldService.addValues(FieldMapper.toDataRows(field.copy(uuid = f.uuid.toOpt()), f.uuid)).map(v => RichField(f, v))
      }
    ).map(FieldMapper.toDto(_))
  }

  /**
   * Get a field
   */
  override def getField()(implicit request: Request[AnyContent]): Future[List[Field]] = run { implicit u =>
    db.run(
      for {
        fields <- fieldService.allFields
        defaultValues <- fieldDataService.fieldDefaultData(fields.map(_.fieldUuid)).result.map(_.groupBy(_.fieldUuid))
      } yield (fields.map(f => RichField(f, defaultValues.get(f.uuid).getOrElse(Nil))))
    ).map(_.map(FieldMapper.toDto(_)).toList)
  }

  /**
   * update a field
   */
  override def updateField(uuid: String, field: Field)(implicit request: Request[AnyContent]): Future[Field] = run { implicit u =>
    val newField = FieldMapper.toRow(field).copy(uuid = uuid)

    def updateIfNeeded(f: tables.Tables.FieldRow) = {
      if (!f.equivalent(newField)) fieldService.add(newField.field)
      else DBIOAction.successful(f)
    }

    db.run(
      for {
        f <- fieldService.getField(uuid)
        fd <- fieldDataService.fieldData(uuid, uuid).result
        nf <- updateIfNeeded(f)
        nd <- fieldDataService.updateFieldValues(fd.toList, FieldMapper.toDataRows(field, uuid))
      } yield (RichField(nf, nd))
    ).map(FieldMapper.toDto(_))
  }

  /**
   * delete a field
   */
  override def deleteField(uuid: String)(implicit request: Request[AnyContent]): Future[Unit] = run { implicit u =>
    db.run(this.fieldService.delete(uuid))
      .map(_ => Unit)
  }
}
