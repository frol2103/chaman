package be.frol.chaman.api

import be.frol.chaman.core.field.FieldTypes
import be.frol.chaman.mapper.FieldMapper
import be.frol.chaman.model.RichModelConversions._
import be.frol.chaman.openapi.api.{DatatypesApi, FieldApi}
import be.frol.chaman.openapi.model.{Field, FieldType}
import be.frol.chaman.service.FieldService
import be.frol.chaman.tables
import play.api.db.slick.DatabaseConfigProvider
import play.api.mvc.{AnyContent, ControllerComponents, Request}
import slick.dbio.DBIOAction

import javax.inject.Inject
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class DatatypesApiImpl @Inject()(
                              val cc: ControllerComponents,
                              val dbConfigProvider: DatabaseConfigProvider,
                  ) extends DatatypesApi with DbContext {
  /**
   * get data type
   */
  override def getDataTypes()(implicit request: Request[AnyContent]): Future[List[FieldType]] = {
    Future.successful(FieldTypes.all.map(ft =>
      new FieldType(ft.identifier)
    ))
  }
}
