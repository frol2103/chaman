package be.frol.chaman.openapi.model

import play.api.libs.json._

/**
  * Represents the Swagger definition for Event.
  */
@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"))
case class Event(
  eventType: Option[Event.EventType.Value],
  itemId: Option[String],
  content: Option[String]
)

object Event {
  implicit lazy val eventJsonFormat: Format[Event] = Json.format[Event]

  // noinspection TypeAnnotation
  object EventType extends Enumeration {
    val TakePicture = Value("TakePicture")
    val TakeThumbnail = Value("TakeThumbnail")

    type EventType = Value
    implicit lazy val EventTypeJsonFormat: Format[Value] = Format(Reads.enumNameReads(this), Writes.enumNameWrites[this.type])
  }
}

