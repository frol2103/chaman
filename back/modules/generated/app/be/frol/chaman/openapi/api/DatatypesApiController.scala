package be.frol.chaman.openapi.api

import org.openapitools.OpenApiExceptions
import javax.inject.{Inject, Singleton}
import play.api.libs.json._
import play.api.mvc._
import scala.concurrent.{ExecutionContext, Future}
import be.frol.chaman.openapi.model.FieldType

@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
@Singleton
class DatatypesApiController @Inject()(cc: ControllerComponents, api: DatatypesApi)(implicit executionContext: ExecutionContext) extends AbstractController(cc) {
  /**
    * GET /api/data-types/
    */
  def getDataTypes(): Action[AnyContent] = Action.async { request =>
    def executeApi(): Future[List[FieldType]] = {
      api.getDataTypes()(request)
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
