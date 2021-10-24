package be.frol.chaman.openapi.api

import play.api.libs.json._
import play.api.mvc._
import scala.concurrent.Future
import be.frol.chaman.openapi.model.Event

@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
trait EventApi {
  /**
    * add an event
    */
  def addEvent(event: Option[Event])(implicit request:Request[AnyContent]): Future[Unit]

}
