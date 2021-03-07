package be.frol.chaman.openapi.model

import play.api.libs.json._

/**
  * Represents the Swagger definition for Template.
  */
@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
case class Template(
  uuid: Option[String],
  parent: Option[List[Template]],
  content: Option[List[FieldContent]]
)

object Template {
  implicit lazy val templateJsonFormat: Format[Template] = Json.format[Template]
}

