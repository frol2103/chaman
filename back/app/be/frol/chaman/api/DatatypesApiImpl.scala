package be.frol.chaman.api

import be.frol.chaman.core.field.FieldTypes
import be.frol.chaman.mapper.FieldMapper
import be.frol.chaman.openapi.api.DatatypesApi
import be.frol.chaman.openapi.model.{FieldConfig, FieldType}
import play.api.db.slick.DatabaseConfigProvider
import play.api.mvc.{AnyContent, ControllerComponents, Request}

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
  override def getDataTypes()(implicit request: Request[AnyContent]): Future[List[FieldConfig]] = {
    Future.apply(FieldTypes.all.map(FieldMapper.toConfigDto(_)))
  }
}
