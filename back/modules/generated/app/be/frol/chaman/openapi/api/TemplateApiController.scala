package be.frol.chaman.openapi.api

import org.openapitools.OpenApiExceptions
import javax.inject.{Inject, Singleton}
import play.api.libs.json._
import play.api.mvc._
import scala.concurrent.{ExecutionContext, Future}
import be.frol.chaman.openapi.model.Template

@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
@Singleton
class TemplateApiController @Inject()(cc: ControllerComponents, api: TemplateApi)(implicit executionContext: ExecutionContext) extends AbstractController(cc) {
  /**
    * POST /api/template
    */
  def createTemplate(): Action[AnyContent] = Action.async { request =>
    def executeApi(): Future[Template] = {
      val template = request.body.asJson.map(_.as[Template]).getOrElse {
        throw new OpenApiExceptions.MissingRequiredParameterException("body", "template")
      }
      api.createTemplate(template)(request)
    }

    executeApi().map { result =>
      val json = Json.toJson(result)
      Ok(json)
    }
  }

  /**
    * DELETE /api/template/:uuid
    */
  def deleteTemplate(uuid: String): Action[AnyContent] = Action.async { request =>
    def executeApi(): Future[Unit] = {
      api.deleteTemplate(uuid)(request)
    }

    executeApi().map { _ =>
      Ok
    }
  }

  /**
    * GET /api/template/:uuid
    */
  def getTemplate(uuid: String): Action[AnyContent] = Action.async { request =>
    def executeApi(): Future[Template] = {
      api.getTemplate(uuid)(request)
    }

    executeApi().map { result =>
      val json = Json.toJson(result)
      Ok(json)
    }
  }

  /**
    * GET /api/template
    */
  def getTemplates(): Action[AnyContent] = Action.async { request =>
    def executeApi(): Future[List[Template]] = {
      api.getTemplates()(request)
    }

    executeApi().map { result =>
      val json = Json.toJson(result)
      Ok(json)
    }
  }

  /**
    * PUT /api/template/:uuid
    */
  def updateTemplate(uuid: String): Action[AnyContent] = Action.async { request =>
    def executeApi(): Future[Template] = {
      val template = request.body.asJson.map(_.as[Template]).getOrElse {
        throw new OpenApiExceptions.MissingRequiredParameterException("body", "template")
      }
      api.updateTemplate(uuid, template)(request)
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
