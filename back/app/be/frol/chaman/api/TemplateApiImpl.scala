package be.frol.chaman.api

import be.frol.chaman.mapper.{FieldMapper, TemplateMapper}
import be.frol.chaman.model.RichField
import be.frol.chaman.model.RichModelConversions._
import be.frol.chaman.openapi.api.{FieldApi, TemplateApi}
import be.frol.chaman.openapi.model.{Field, Template}
import be.frol.chaman.service.{FieldDataService, FieldService, TemplateService}
import be.frol.chaman.tables
import play.api.db.slick.DatabaseConfigProvider
import play.api.mvc.{AnyContent, ControllerComponents, Request}
import slick.dbio.DBIOAction
import be.frol.chaman.mapper.TraversableUtils._

import javax.inject.Inject
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import be.frol.chaman.utils.OptionUtils._

class TemplateApiImpl @Inject()(
                              val cc: ControllerComponents,
                              val dbConfigProvider: DatabaseConfigProvider,
                              val templateService: TemplateService,
                              val fieldDataService: FieldDataService,
                              val fieldService: FieldService,
                  ) extends TemplateApi with DbContext {
  /**
   * create a template
   */
  override def createTemplate(template: Template)(implicit request: Request[AnyContent]): Future[Template] = {
    db.run(this.templateService.add(TemplateMapper.toRow(template))).map(TemplateMapper.toDto(_))
  }

  /**
   * get a template
   */
  override def getTemplate(uuid: String)(implicit request: Request[AnyContent]): Future[Template] = {
    db.run(
      getTemplateDto(uuid)
    )
  }

  private def getTemplateDto(uuid: String) = {
    for {
      template <- templateService.find(uuid)
      fields <- fieldDataService.fieldsFor(template.uuid)
    } yield TemplateMapper.toDto(template, fields.toOpt)
  }

  /**
   * Get all templates
   */
  override def getTemplates()(implicit request: Request[AnyContent]): Future[List[Template]] = {
    db.run(templateService.all.map(_.map(TemplateMapper.toDto(_)).toList))
  }

  /**
   * update a template
   */
    override def updateTemplate(uuid: String, template: Template)(implicit request: Request[AnyContent]): Future[Template] = {

      val targetFieldsData = template.content.getOrElse(Nil).map(FieldMapper.toDataRow(_, uuid))

      db.run((for {
        currentFields <- this.fieldDataService.fieldsFor(uuid).map(_.toMapBy(_.field.uuid));
        missingFieldsDescriptors <- fieldService.getFields((targetFieldsData.map(_.fieldUuid).toSet -- (currentFields.keys.toSet)).toSeq:_*).map(_.toMapBy(_.uuid))
      } yield (currentFields, missingFieldsDescriptors))
        .flatMap{case (currentFields, missingFieldsDescriptors) =>
          val fields = missingFieldsDescriptors ++ currentFields.mapValues(_.field)
          this.fieldDataService.updateFields(currentFields, targetFieldsData.map(fd => new RichField(fields(fd.fieldUuid), fd.toOpt)))
        }
        .flatMap(_ => this.templateService.add(TemplateMapper.toRow(template)))
        .flatMap(_ => getTemplateDto(uuid))
      )
  }

  /**
   * delete a template
   */
  override def deleteTemplate(uuid: String)(implicit request: Request[AnyContent]): Future[Unit] = {
    db.run(this.templateService.delete(uuid))
      .map(_ => Unit)
  }
}
