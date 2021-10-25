package be.frol.chaman.openapi.api

import org.openapitools.OpenApiExceptions
import javax.inject.{Inject, Singleton}
import play.api.libs.json._
import play.api.mvc._
import scala.concurrent.{ExecutionContext, Future}

@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
@Singleton
class TagApiController @Inject()(cc: ControllerComponents, api: TagApi)(implicit executionContext: ExecutionContext) extends AbstractController(cc) {
  /**
    * PUT /api/field/:uuid/tag?value=[value]
    */
  def addTag(uuid: String): Action[AnyContent] = Action.async { request =>
    def executeApi(): Future[Unit] = {
      val value = request.getQueryString("value")
        .getOrElse {
          throw new OpenApiExceptions.MissingRequiredParameterException("value", "query string")
        }
      api.addTag(uuid, value)(request)
    }

    executeApi().map { _ =>
      Ok
    }
  }

  /**
    * GET /api/field/:uuid/tag
    */
  def getAllTags(uuid: String): Action[AnyContent] = Action.async { request =>
    def executeApi(): Future[List[String]] = {
      api.getAllTags(uuid)(request)
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
