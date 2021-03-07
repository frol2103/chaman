package be.frol.chaman.api

import be.frol.chaman.openapi.api.FieldApi
import be.frol.chaman.openapi.model.Field
import play.api.mvc.{AnyContent, Request}

import java.util.UUID
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class FieldApiImpl extends FieldApi{
  /**
   * Get a field
   */
  override def getField()(implicit request: Request[AnyContent]): Future[Field] = {
    Future(Field(Option(UUID.randomUUID()),Option(UUID.randomUUID()), None,None))
  }
}
