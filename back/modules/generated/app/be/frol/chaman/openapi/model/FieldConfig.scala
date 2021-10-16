package be.frol.chaman.openapi.model

import play.api.libs.json._

/**
  * Represents the Swagger definition for FieldConfig.
  */
@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
case class FieldConfig(
  label: Option[String],
  reference: Option[String],
  datatype: Option[String],
  config: Option[List[Field]]
)

object FieldConfig {
  implicit lazy val fieldConfigJsonFormat: Format[FieldConfig] = Json.format[FieldConfig]
}

