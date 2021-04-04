package be.frol.chaman.api

import be.frol.chaman.mapper.{FieldMapper, TemplateMapper}
import be.frol.chaman.model.RichModelConversions._
import be.frol.chaman.openapi.api.{FieldApi, TemplateApi}
import be.frol.chaman.openapi.model.{Field, Template}
import be.frol.chaman.service.{FieldService, TemplateService}
import be.frol.chaman.tables
import play.api.db.slick.DatabaseConfigProvider
import play.api.mvc.{AnyContent, ControllerComponents, Request}
import slick.dbio.DBIOAction

import javax.inject.Inject
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class TemplateApiImpl @Inject()(
                              val cc: ControllerComponents,
                              val dbConfigProvider: DatabaseConfigProvider,
                              val templateService: TemplateService,
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
    db.run(templateService.find(uuid).map(TemplateMapper.toDto(_)))
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
    db.run(this.templateService.add(TemplateMapper.toRow(template))).map(TemplateMapper.toDto(_))
  }
}
