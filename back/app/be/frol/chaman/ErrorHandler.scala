package be.frol.chaman

import be.frol.chaman.error.AuthentificationError
import play.api.Logging
import play.api.http.HttpErrorHandler
import play.api.mvc.{RequestHeader, Result}
import play.api.mvc.Results.{BadRequest, InternalServerError, Unauthorized}

import javax.inject.Singleton
import scala.concurrent.Future

@Singleton
class ErrorHandler extends HttpErrorHandler with Logging{
  override def onClientError(request: RequestHeader, statusCode: Int, message: String): Future[Result] = {
    Future.successful(InternalServerError(message))
  }

  override def onServerError(request: RequestHeader, exception: Throwable): Future[Result] = {
    exception match {
      case a: AuthentificationError => Future.successful(Unauthorized)
      case _ => {
        logger.error("Server error", exception)
        Future.successful(InternalServerError(exception.getMessage))
      }
    }
  }
}
