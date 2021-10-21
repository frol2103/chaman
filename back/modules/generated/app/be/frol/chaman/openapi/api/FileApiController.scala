package be.frol.chaman.openapi.api

import org.openapitools.OpenApiExceptions
import javax.inject.{Inject, Singleton}
import play.api.libs.json._
import play.api.mvc._
import scala.concurrent.{ExecutionContext, Future}

@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
@Singleton
class FileApiController @Inject()(cc: ControllerComponents, api: FileApi)(implicit executionContext: ExecutionContext) extends AbstractController(cc) {
  /**
    * GET /api/annex/:uuid/file
    */
  def getAnnexFile(uuid: String): Action[AnyContent] = Action.async { request =>
    def executeApi(): Future[Unit] = {
      api.getAnnexFile(uuid)(request)
    }

    executeApi().map { _ =>
      Ok
    }
  }

  /**
    * GET /api/item/:uuid/thumbnail/file
    */
  def getThumbnailFile(uuid: String): Action[AnyContent] = Action.async { request =>
    def executeApi(): Future[Unit] = {
      api.getThumbnailFile(uuid)(request)
    }

    executeApi().map { _ =>
      Ok
    }
  }

  private def splitCollectionParam(paramValues: String, collectionFormat: String): List[String] = {
    val splitBy =
      collectionFormat match {
        case "csv" => ",+"
        case "tsv" => "\t+"
        case "ssv" => " +"
        case "pipes" => "|+"
      }

    paramValues.split(splitBy).toList
  }
}
