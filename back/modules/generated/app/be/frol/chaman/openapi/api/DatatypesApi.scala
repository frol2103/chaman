package be.frol.chaman.openapi.api

import play.api.libs.json._
import play.api.mvc._
import scala.concurrent.Future
import be.frol.chaman.openapi.model.FieldConfig

@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
trait DatatypesApi {
  /**
    * get data type
    */
  def getDataTypes()(implicit request:Request[AnyContent]): Future[List[FieldConfig]]

}
