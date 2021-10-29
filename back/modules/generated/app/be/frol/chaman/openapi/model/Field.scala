package be.frol.chaman.openapi.model

import play.api.libs.json._

/**
  * Represents the Swagger definition for Field.
  * @param uuid single uuid acrross all version of the field
  * @param isUserField true if the field is user defined false if its a deault field
  */
@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
case class Field(
  uuid: Option[String],
  label: Option[String],
  reference: Option[String],
  inputType: Option[String],
  value: Option[List[FieldValue]],
  params: Option[JsValue],
  errorMessages: Option[List[String]],
  isUserField: Option[Boolean]
)

object Field {
  implicit lazy val fieldJsonFormat: Format[Field] = Json.format[Field]
}

