package be.frol.chaman.openapi.model

import play.api.libs.json._
import java.util.UUID

/**
  * Represents the Swagger definition for Field.
  * @param uuid single uuid acrross all version of the field
  * @param value value of the type
  */
@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
case class Field(
  uuid: Option[UUID],
  label: Option[String],
  reference: Option[String],
  dataType: Option[String],
  value: Option[JsObject],
  valueOrigin: Option[UUID]
)

object Field {
  implicit lazy val fieldJsonFormat: Format[Field] = Json.format[Field]
}

