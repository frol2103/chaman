package be.frol.chaman.openapi.model

import play.api.libs.json._

/**
  * Represents the Swagger definition for FieldType.
  */
@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
case class FieldType(
  identifier: String
)

object FieldType {
  implicit lazy val fieldTypeJsonFormat: Format[FieldType] = Json.format[FieldType]
}

