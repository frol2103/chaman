package be.frol.chaman.openapi.api

import play.api.libs.json._
import scala.concurrent.Future
import be.frol.chaman.openapi.model.Field
import play.api.mvc._
import be.frol.chaman.openapi.model.FieldConfig
import play.api.mvc._

@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
trait FieldApi {
  /**
    * create a field
    */
  def createField(fieldConfig: FieldConfig)(implicit request:Request[AnyContent]): Future[Field]


  /**
    * delete a field
    */
  def deleteField(uuid: String)(implicit request:Request[AnyContent]): Future[Unit]


  /**
    * Get a field
    */
  def getField()(implicit request:Request[AnyContent]): Future[List[Field]]


  /**
    * get a field config
    */
  def getFieldConfig(uuid: String)(implicit request:Request[AnyContent]): Future[FieldConfig]


  /**
    * update a field
    */
  def updateField(uuid: String, fieldConfig: FieldConfig)(implicit request:Request[AnyContent]): Future[Field]

}
