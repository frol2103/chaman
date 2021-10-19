package be.frol.chaman.openapi.api

import play.api.libs.json._
import scala.concurrent.Future
import play.api.mvc._

@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
trait FileApi {
  /**
    * get a file
    */
  def getAnnexFile(uuid: String)(implicit request:Request[AnyContent]): Future[Unit]

}
