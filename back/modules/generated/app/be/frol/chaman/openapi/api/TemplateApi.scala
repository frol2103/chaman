package be.frol.chaman.openapi.api

import play.api.libs.json._
import scala.concurrent.Future
import be.frol.chaman.openapi.model.Template
import play.api.mvc._

@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
trait TemplateApi {
  /**
    * create a template
    */
  def createTemplate(template: Template)(implicit request:Request[AnyContent]): Future[Template]


  /**
    * get a template
    */
  def getTemplate(uuid: String)(implicit request:Request[AnyContent]): Future[Template]


  /**
    * Get all templates
    */
  def getTemplates()(implicit request:Request[AnyContent]): Future[List[Template]]


  /**
    * update a template
    */
  def updateTemplate(uuid: String, template: Template)(implicit request:Request[AnyContent]): Future[Template]

}
