package be.frol.chaman.openapi.api

import org.openapitools.OpenApiExceptions
import javax.inject.{Inject, Singleton}
import play.api.libs.json._
import play.api.mvc._
import scala.concurrent.{ExecutionContext, Future}
import be.frol.chaman.openapi.model.Link

@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
@Singleton
class LinkApiController @Inject()(cc: ControllerComponents, api: LinkApi)(implicit executionContext: ExecutionContext) extends AbstractController(cc) {
  /**
    * POST /api/item/:uuid/link?linkedUuid=[value]
    */
  def addLink(uuid: String): Action[AnyContent] = Action.async { request =>
    def executeApi(): Future[Link] = {
      val linkedUuid = request.getQueryString("linkedUuid")
        .getOrElse {
          throw new OpenApiExceptions.MissingRequiredParameterException("linkedUuid", "query string")
        }
      api.addLink(uuid, linkedUuid)(request)
    }

    executeApi().map { result =>
      val json = Json.toJson(result)
      Ok(json)
    }
  }

  /**
    * DELETE /api/link/:uuid
    */
  def deleteLink(uuid: String): Action[AnyContent] = Action.async { request =>
    def executeApi(): Future[Unit] = {
      api.deleteLink(uuid)(request)
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
