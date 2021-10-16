package be.frol.chaman.openapi.api

import org.openapitools.OpenApiExceptions
import javax.inject.{Inject, Singleton}
import play.api.libs.json._
import play.api.mvc._
import scala.concurrent.{ExecutionContext, Future}
import be.frol.chaman.openapi.model.Field
import be.frol.chaman.openapi.model.FieldConfig

@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
@Singleton
class FieldApiController @Inject()(cc: ControllerComponents, api: FieldApi)(implicit executionContext: ExecutionContext) extends AbstractController(cc) {
  /**
    * POST /api/field
    */
  def createField(): Action[AnyContent] = Action.async { request =>
    def executeApi(): Future[Field] = {
      val fieldConfig = request.body.asJson.map(_.as[FieldConfig]).getOrElse {
        throw new OpenApiExceptions.MissingRequiredParameterException("body", "fieldConfig")
      }
      api.createField(fieldConfig)(request)
    }

    executeApi().map { result =>
      val json = Json.toJson(result)
      Ok(json)
    }
  }

  /**
    * DELETE /api/field/:uuid
    */
  def deleteField(uuid: String): Action[AnyContent] = Action.async { request =>
    def executeApi(): Future[Unit] = {
      api.deleteField(uuid)(request)
    }

    executeApi().map { _ =>
      Ok
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
    * GET /api/field/:uuid
    */
  def getFieldConfig(uuid: String): Action[AnyContent] = Action.async { request =>
    def executeApi(): Future[FieldConfig] = {
      api.getFieldConfig(uuid)(request)
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
      val fieldConfig = request.body.asJson.map(_.as[FieldConfig]).getOrElse {
        throw new OpenApiExceptions.MissingRequiredParameterException("body", "fieldConfig")
      }
      api.updateField(uuid, fieldConfig)(request)
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
