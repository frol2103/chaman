package be.frol.chaman.model

import be.frol.chaman.tables.Tables.{FieldDataRow, FieldRow}
import be.frol.chaman.utils.OptionUtils._

case class RichField(field: FieldRow, fieldData: Option[FieldDataRow]) {
  def fieldUuid = field.uuid

  def serializedValue = fieldData.flatMap(_.value).orElse(field.defaultValue)

  def equivalent(other: RichField) = {
    def removeNonImportant(f: FieldRow) = f.copy(id = 0L, timestamp = null, defaultValue = None)

    def removeNonImportantData(f: FieldDataRow) = f.copy(id = 0L, timestamp = null, value = None)

    removeNonImportant(field) == removeNonImportant(other.field) &&
      fieldData.map(removeNonImportantData) == other.fieldData.map(removeNonImportantData) &&
      serializedValue == other.serializedValue
  }
}

object RichField {
  def apply(d: (FieldDataRow, FieldRow)): RichField = RichField(d._2, d._1.toOpt)
}
