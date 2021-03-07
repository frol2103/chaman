package be.frol.chaman.openapi.model

import play.api.libs.json._
import java.util.UUID

/**
  * Represents the Swagger definition for Field.
  * @param uuid single uuid acrross all version of the field
  * @param versionUuid version specific uuid of the field
  */
@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
case class Field(
  uuid: Option[UUID],
  versionUuid: Option[UUID],
  reference: Option[String],
  dataType: Option[String]
)

object Field {
  implicit lazy val fieldJsonFormat: Format[Field] = Json.format[Field]
}

