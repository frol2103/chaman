package be.frol.chaman.openapi.model

import play.api.libs.json._

/**
  * Represents the Swagger definition for Thumbnail.
  */
@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
case class Thumbnail(
  annexUuid: Option[String],
  x: Option[BigDecimal],
  y: Option[BigDecimal],
  width: Option[BigDecimal]
)

object Thumbnail {
  implicit lazy val thumbnailJsonFormat: Format[Thumbnail] = Json.format[Thumbnail]
}

