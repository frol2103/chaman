package be.frol.chaman.openapi.model

import play.api.libs.json._

/**
  * Represents the Swagger definition for Item.
  */
@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
case class Item(
  uuid: Option[String],
  title: Option[String],
  description: Option[String],
  content: Option[List[Field]]
)

object Item {
  implicit lazy val itemJsonFormat: Format[Item] = Json.format[Item]
}

