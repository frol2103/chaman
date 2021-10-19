package be.frol.chaman.openapi.model

import play.api.libs.json._

/**
  * Represents the Swagger definition for Annex.
  */
@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
case class Annex(
  uuid: Option[String],
  filename: Option[String],
  mime: Option[String]
)

object Annex {
  implicit lazy val annexJsonFormat: Format[Annex] = Json.format[Annex]
}

