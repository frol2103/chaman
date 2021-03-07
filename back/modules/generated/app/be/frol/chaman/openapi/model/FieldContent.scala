package be.frol.chaman.openapi.model

import play.api.libs.json._
import java.util.UUID

/**
  * Represents the Swagger definition for FieldContent.
  * @param value value of the type
  */
@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
case class FieldContent(
  fieldUuid: Option[String],
  value: Option[JsObject],
  valueOrigin: Option[UUID]
)

object FieldContent {
  implicit lazy val fieldContentJsonFormat: Format[FieldContent] = Json.format[FieldContent]
}

