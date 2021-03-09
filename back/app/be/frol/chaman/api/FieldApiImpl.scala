package be.frol.chaman.api

import be.frol.chaman.openapi.api.FieldApi
import be.frol.chaman.openapi.model.Field
import play.api.db.slick.DatabaseConfigProvider
import play.api.mvc.{AnyContent, ControllerComponents, Request}

import java.util.UUID
import javax.inject.Inject
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import be.frol.chaman.utils.OptionUtils._

class FieldApiImpl @Inject()(
                              val cc: ControllerComponents,
                              val dbConfigProvider: DatabaseConfigProvider,
                  ) extends FieldApi with DbContext {
  import api._

  /**
   * create a field
   */
  override def createField(field: Field)(implicit request: Request[AnyContent]): Future[Field] =
    ???

  /**
   * Get a field
   */
  override def getField()(implicit request: Request[AnyContent]): Future[List[Field]] =
    ???

  /**
   * update a field
   */
  override def updateField(uuid: String, field: Field)(implicit request: Request[AnyContent]): Future[Field] =
    ???
}
