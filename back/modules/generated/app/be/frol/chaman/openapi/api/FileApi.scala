package be.frol.chaman.openapi.api

import play.api.libs.json._
import play.api.mvc._
import scala.concurrent.Future

@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
trait FileApi {
  /**
    * get a file
    */
  def getAnnexFile(uuid: String)(implicit request:Request[AnyContent]): Future[Unit]


  /**
    * get a thumbnail file
    */
  def getThumbnailFile(uuid: String)(implicit request:Request[AnyContent]): Future[Unit]

}
