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
import slick.dbio.{DBIO, DBIOAction, Effect, NoStream}
import be.frol.chaman.mapper.TraversableUtils._
import be.frol.chaman.tables.Tables

import javax.inject.Inject
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import be.frol.chaman.utils.OptionUtils._
import play.api.Logging

class TemplateApiImpl @Inject()(
                              val cc: ControllerComponents,
                              val dbConfigProvider: DatabaseConfigProvider,
                              val templateService: TemplateService,
                              val fieldDataService: FieldDataService,
                              val fieldService: FieldService,
                  ) extends TemplateApi with DbContext with Logging{
  /**
   * create a template
   */
  override def createTemplate(template: Template)(implicit request: Request[AnyContent]): Future[Template] = {
    db.run(this.templateService.add(TemplateMapper.toRow(template)))
      .flatMap(r => db.run(getTemplateDto(r.uuid)))
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
      form <- templateService.richFormWithParents(uuid)
    } yield  {
      TemplateMapper.toDto(form)
    }
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
      import api._
      db.run(
        updateParents(uuid, template.parents.getOrElse(Nil).flatMap(_.uuid))
          .flatMap(_ => updateFields(uuid, targetFieldsData))
          .flatMap(_ => this.templateService.add(TemplateMapper.toRow(template)))
          .transactionally
      ).flatMap(_ => db.run(
        getTemplateDto(uuid)
      ))
    }

  private def updateFields(uuid: String, targetFieldsData: List[Tables.FieldDataRow]) = {
    (for {
      currentForm <- templateService.richFormWithParents(uuid)
      missingFieldsDescriptors <- fieldService.getFields((targetFieldsData.map(_.fieldUuid).toSet -- (currentForm.fields.keys.toSet)).toSeq: _*).map(_.toMapBy(_.uuid))
    } yield (currentForm, missingFieldsDescriptors))
      .flatMap { case (currentForm, missingFieldsDescriptors) =>
        val fields = missingFieldsDescriptors ++ currentForm.fields.values.map(_.field).toMapBy(_.uuid)
        this.fieldDataService.updateFields(currentForm.fields, targetFieldsData.map(fd => new RichField(fields(fd.fieldUuid), fd.toOpt)))
      }
  }

  private def updateParents(uuid: String, target : List[String]) = {
    templateService.allParents(uuid :: target).flatMap { allParents =>
      allParents.assertNoCycles(uuid, parents=target)
      templateService.updateParents(uuid, allParents.parentsRowsFor(uuid), target.toSet)
    }
  }

  /**
   * delete a template
   */
  override def deleteTemplate(uuid: String)(implicit request: Request[AnyContent]): Future[Unit] = {
    db.run(this.templateService.delete(uuid))
      .map(_ => Unit)
  }
}
