package be.frol.chaman.openapi.api

import org.openapitools.OpenApiExceptions
import javax.inject.{Inject, Singleton}
import play.api.libs.json._
import play.api.mvc._
import scala.concurrent.{ExecutionContext, Future}
import be.frol.chaman.openapi.model.Field

@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
@Singleton
class FieldApiController @Inject()(cc: ControllerComponents, api: FieldApi)(implicit executionContext: ExecutionContext) extends AbstractController(cc) {
  /**
    * GET /api/field
    */
  def getField(): Action[AnyContent] = Action.async { request =>
    def executeApi(): Future[Field] = {
      api.getField()(request)
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
