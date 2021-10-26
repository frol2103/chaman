package be.frol.chaman.openapi.model

import play.api.libs.json._

/**
  * Represents the Swagger definition for ItemDescr.
  */
@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
case class ItemDescr(
  uuid: Option[String],
  title: Option[String],
  description: Option[String]
)

object ItemDescr {
  implicit lazy val itemDescrJsonFormat: Format[ItemDescr] = Json.format[ItemDescr]
}

