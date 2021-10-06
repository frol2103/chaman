package be.frol.chaman.openapi.api

import org.openapitools.OpenApiExceptions
import javax.inject.{Inject, Singleton}
import play.api.libs.json._
import play.api.mvc._
import scala.concurrent.{ExecutionContext, Future}
import be.frol.chaman.openapi.model.Item

@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
@Singleton
class ItemApiController @Inject()(cc: ControllerComponents, api: ItemApi)(implicit executionContext: ExecutionContext) extends AbstractController(cc) {
  /**
    * POST /api/item
    */
  def createItem(): Action[AnyContent] = Action.async { request =>
    def executeApi(): Future[Item] = {
      val item = request.body.asJson.map(_.as[Item]).getOrElse {
        throw new OpenApiExceptions.MissingRequiredParameterException("body", "item")
      }
      api.createItem(item)(request)
    }

    executeApi().map { result =>
      val json = Json.toJson(result)
      Ok(json)
    }
  }

  /**
    * DELETE /api/item/:uuid
    */
  def deleteItem(uuid: String): Action[AnyContent] = Action.async { request =>
    def executeApi(): Future[Unit] = {
      api.deleteItem(uuid)(request)
    }

    executeApi().map { _ =>
      Ok
    }
  }

  /**
    * GET /api/item/:uuid
    */
  def getItem(uuid: String): Action[AnyContent] = Action.async { request =>
    def executeApi(): Future[Item] = {
      api.getItem(uuid)(request)
    }

    executeApi().map { result =>
      val json = Json.toJson(result)
      Ok(json)
    }
  }

  /**
    * GET /api/item
    */
  def getItems(): Action[AnyContent] = Action.async { request =>
    def executeApi(): Future[List[Item]] = {
      api.getItems()(request)
    }

    executeApi().map { result =>
      val json = Json.toJson(result)
      Ok(json)
    }
  }

  /**
    * PUT /api/item/:uuid
    */
  def updateItem(uuid: String): Action[AnyContent] = Action.async { request =>
    def executeApi(): Future[Item] = {
      val item = request.body.asJson.map(_.as[Item]).getOrElse {
        throw new OpenApiExceptions.MissingRequiredParameterException("body", "item")
      }
      api.updateItem(uuid, item)(request)
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