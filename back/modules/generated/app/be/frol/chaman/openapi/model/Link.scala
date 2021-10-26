package be.frol.chaman.openapi.model

import play.api.libs.json._

/**
  * Represents the Swagger definition for Link.
  */
@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
case class Link(
  uuid: Option[String],
  item: Option[ItemDescr]
)

object Link {
  implicit lazy val linkJsonFormat: Format[Link] = Json.format[Link]
}

