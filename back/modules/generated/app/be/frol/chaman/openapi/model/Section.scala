package be.frol.chaman.openapi.model

import play.api.libs.json._

/**
  * Represents the Swagger definition for Section.
  */
@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
case class Section(
  uuid: Option[String],
  label: Option[String],
  reference: Option[String],
  content: Option[List[Field]]
)

object Section {
  implicit lazy val sectionJsonFormat: Format[Section] = Json.format[Section]
}

