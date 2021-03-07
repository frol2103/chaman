package be.frol.chaman.openapi.api

import play.api.libs.json._
import scala.concurrent.Future
import be.frol.chaman.openapi.model.Field
import play.api.mvc._

@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
trait FieldApi {
  /**
    * Get a field
    */
  def getField()(implicit request:Request[AnyContent]): Future[Field]

}
