package be.frol.chaman.openapi.api

import org.openapitools.OpenApiExceptions
import javax.inject.{Inject, Singleton}
import play.api.libs.json._
import play.api.mvc._
import scala.concurrent.{ExecutionContext, Future}
import be.frol.chaman.openapi.model.Thumbnail

@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
@Singleton
class ThumbnailApiController @Inject()(cc: ControllerComponents, api: ThumbnailApi)(implicit executionContext: ExecutionContext) extends AbstractController(cc) {
  /**
    * GET /api/item/:uuid/thumbnail
    */
  def getDescription(uuid: String): Action[AnyContent] = Action.async { request =>
    def executeApi(): Future[Thumbnail] = {
      api.getDescription(uuid)(request)
    }

    executeApi().map { result =>
      val json = Json.toJson(result)
      Ok(json)
    }
  }

  /**
    * PUT /api/item/:uuid/thumbnail
    */
  def setDescription(uuid: String): Action[AnyContent] = Action.async { request =>
    def executeApi(): Future[Thumbnail] = {
      val thumbnail = request.body.asJson.map(_.as[Thumbnail])
      api.setDescription(uuid, thumbnail)(request)
    }

    executeApi().map { result =>
      val json = Json.toJson(result)
      Ok(json)
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
