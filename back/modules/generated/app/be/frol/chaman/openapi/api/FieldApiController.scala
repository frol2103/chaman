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
    * POST /api/field
    */
  def createField(): Action[AnyContent] = Action.async { request =>
    def executeApi(): Future[Field] = {
      val field = request.body.asJson.map(_.as[Field]).getOrElse {
        throw new OpenApiExceptions.MissingRequiredParameterException("body", "field")
      }
      api.createField(field)(request)
    }

    executeApi().map { result =>
      val json = Json.toJson(result)
      Ok(json)
    }
  }

  /**
    * GET /api/field
    */
  def getField(): Action[AnyContent] = Action.async { request =>
    def executeApi(): Future[List[Field]] = {
      api.getField()(request)
    }

    executeApi().map { result =>
      val json = Json.toJson(result)
      Ok(json)
    }
  }

  /**
    * PUT /api/field/:uuid
    */
  def updateField(uuid: String): Action[AnyContent] = Action.async { request =>
    def executeApi(): Future[Field] = {
      val field = request.body.asJson.map(_.as[Field]).getOrElse {
        throw new OpenApiExceptions.MissingRequiredParameterException("body", "field")
      }
      api.updateField(uuid, field)(request)
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
