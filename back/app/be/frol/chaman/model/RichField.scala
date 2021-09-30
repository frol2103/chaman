package be.frol.chaman.model

import be.frol.chaman.tables.Tables.{FieldDataRow, FieldRow}
import be.frol.chaman.utils.OptionUtils._
import play.api.Logging
import play.api.mvc.BodyParsers.utils

case class RichField(field: FieldRow, fieldData: Option[FieldDataRow], parents : Seq[RichField] = Nil) extends Logging{
  def fieldUuid = field.uuid
  def referenceUuid = fieldData.map(_.referenceUuid)

  def serializedValue:Option[String] = {

    logger.error("field serialized value " + field.uuid + "\n direct value data : " + fieldData.flatMap(_.value)  +
      "\n parents" + parents.map(f => f.fieldUuid + ":" + f.serializedValue).mkString(" ;; ")
    )
    fieldData.flatMap(_.value)
      .orElse(parents.find(_.serializedValue.isDefined).flatMap(_.serializedValue))
      .orElse(field.defaultValue)
  }

  def removeValueIfEquivalentToPrevious() : RichField = {
    val fieldWithDataEmpty = copy(fieldData = fieldData.map(_.copy(value = None)))
    if (equivalent(fieldWithDataEmpty)) fieldWithDataEmpty
    else this
  }

  def equivalent(other: RichField) = {
    def removeNonImportant(f: FieldRow) = f.copy(id = 0L, timestamp = null, defaultValue = None)

    def removeNonImportantData(f: FieldDataRow) = f.copy(id = 0L, timestamp = null, value = None, referenceUuid = "")

    removeNonImportant(field) == removeNonImportant(other.field) &&
      fieldData.map(removeNonImportantData) == other.fieldData.map(removeNonImportantData) &&
      serializedValue == other.serializedValue
  }

}

object RichField {
  def apply(d: (FieldDataRow, FieldRow)): RichField = RichField(d._2, d._1.toOpt)
}
