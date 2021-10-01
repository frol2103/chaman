package be.frol.chaman.openapi.model

import play.api.libs.json._

/**
  * Represents the Swagger definition for FieldValue.
  * @param uuid identifier of the value
  * @param value value
  */
@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
case class FieldValue(
  uuid: Option[String],
  value: Option[JsObject]
)

object FieldValue {
  implicit lazy val fieldValueJsonFormat: Format[FieldValue] = Json.format[FieldValue]
}

