package be.frol.chaman.model

import be.frol.chaman.core.field.{BasicFieldType, BasicFieldTypes, FieldTypes, FieldWithConf}
import be.frol.chaman.tables.Tables.{DataRow, FieldRow}
import be.frol.chaman.utils.OptionUtils._
import play.api.Logging
import play.api.libs.json.{JsObject, Json}
import play.api.mvc.BodyParsers.utils

case class RichField(field: FieldRow, fieldData: Iterable[DataRow]) extends Logging{
  def fieldUuid = field.uuid


  def equivalent(other: RichField) = {
    def removeNonImportant(f: FieldRow) = f.copy(id = 0L, timestamp = null)
    removeNonImportant(field) == removeNonImportant(other.field)
  }

}

