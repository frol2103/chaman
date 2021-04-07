package be.frol.chaman.openapi.api

import play.api.libs.json._
import scala.concurrent.Future
import be.frol.chaman.openapi.model.Field
import play.api.mvc._

@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
trait FieldApi {
  /**
    * create a field
    */
  def createField(field: Field)(implicit request:Request[AnyContent]): Future[Field]


  /**
    * delete a field
    */
  def deleteField(uuid: String)(implicit request:Request[AnyContent]): Future[Unit]


  /**
    * Get a field
    */
  def getField()(implicit request:Request[AnyContent]): Future[List[Field]]


  /**
    * update a field
    */
  def updateField(uuid: String, field: Field)(implicit request:Request[AnyContent]): Future[Field]

}
