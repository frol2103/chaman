package be.frol.chaman.openapi.api

import play.api.libs.json._
import play.api.mvc._
import scala.concurrent.Future
import be.frol.chaman.openapi.model.Link

@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
trait LinkApi {
  /**
    * add a link
    */
  def addLink(uuid: String, linkedUuid: String)(implicit request:Request[AnyContent]): Future[Link]


  /**
    * delete a link
    */
  def deleteLink(uuid: String)(implicit request:Request[AnyContent]): Future[Unit]

}
