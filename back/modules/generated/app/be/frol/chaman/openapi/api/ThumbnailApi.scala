package be.frol.chaman.openapi.api

import play.api.libs.json._
import play.api.mvc._
import scala.concurrent.Future
import be.frol.chaman.openapi.model.Thumbnail

@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
trait ThumbnailApi {
  /**
    * get thumbnail description
    */
  def getDescription(uuid: String)(implicit request:Request[AnyContent]): Future[Thumbnail]


  /**
    * set thumbnail description
    */
  def setDescription(uuid: String, thumbnail: Option[Thumbnail])(implicit request:Request[AnyContent]): Future[Thumbnail]

}
