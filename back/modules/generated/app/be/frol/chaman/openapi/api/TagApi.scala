package be.frol.chaman.openapi.api

import play.api.libs.json._
import play.api.mvc._
import scala.concurrent.Future

@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
trait TagApi {
  /**
    * add tag for a field
    */
  def addTag(uuid: String, value: String)(implicit request:Request[AnyContent]): Future[Unit]


  /**
    * get tag list for a field
    */
  def getAllTags(uuid: String)(implicit request:Request[AnyContent]): Future[List[String]]

}
