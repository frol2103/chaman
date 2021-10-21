package be.frol.chaman.openapi.api

import play.api.libs.json._
import play.api.mvc._
import scala.concurrent.Future
import be.frol.chaman.openapi.model.Annex
import play.api.libs.Files.TemporaryFile

@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
trait AnnexApi {
  /**
    * delete an annex
    */
  def deleteAnnex(uuid: String)(implicit request:Request[AnyContent]): Future[Unit]


  /**
    * upload a file
    */
  def uploadFile(uuid: String, file: Option[TemporaryFile])(implicit request:Request[AnyContent]): Future[Annex]

}
