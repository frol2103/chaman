package be.frol.chaman

import be.frol.chaman.error.{AuthentificationError, ValidationError}
import play.api.Logging
import play.api.http.HttpErrorHandler
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.Results.{BadRequest, InternalServerError, Unauthorized}
import play.api.mvc.{RequestHeader, Result}

import javax.inject.Singleton
import scala.concurrent.Future

case class ErrorContent(m: String, content: JsValue)
object ErrorContent{
  implicit val format = Json.format[ErrorContent]
}
@Singleton
class ErrorHandler extends HttpErrorHandler with Logging {
  import ErrorContent.format

  override def onClientError(request: RequestHeader, statusCode: Int, message: String): Future[Result] = {
    Future.successful(InternalServerError(message))
  }

  override def onServerError(request: RequestHeader, exception: Throwable): Future[Result] = {
    exception match {
      case a: AuthentificationError => Future.successful(Unauthorized)
      case v: ValidationError => Future.successful(BadRequest(Json.toJson(ErrorContent(v.getMessage, v.content)))) 
      case _ => {
        logger.error("Server error", exception)
        Future.successful(InternalServerError(exception.getMessage))
      }
    }
  }
}
