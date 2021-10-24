package be.frol.chaman.openapi.api

import org.openapitools.OpenApiExceptions
import javax.inject.{Inject, Singleton}
import play.api.libs.json._
import play.api.mvc._
import scala.concurrent.{ExecutionContext, Future}
import be.frol.chaman.openapi.model.Event

@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
@Singleton
class EventApiController @Inject()(cc: ControllerComponents, api: EventApi)(implicit executionContext: ExecutionContext) extends AbstractController(cc) {
  /**
    * PUT /api/event
    */
  def addEvent(): Action[AnyContent] = Action.async { request =>
    def executeApi(): Future[Unit] = {
      val event = request.body.asJson.map(_.as[Event])
      api.addEvent(event)(request)
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
