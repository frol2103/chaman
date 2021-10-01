package be.frol.chaman.model

import be.frol.chaman.tables.Tables.{FieldDataRow, FieldRow}
import be.frol.chaman.utils.OptionUtils._
import play.api.Logging
import play.api.mvc.BodyParsers.utils

case class RichField(field: FieldRow, fieldData: Iterable[FieldDataRow]) extends Logging{
  def fieldUuid = field.uuid




  def equivalent(other: RichField) = {
    def removeNonImportant(f: FieldRow) = f.copy(id = 0L, timestamp = null)
    removeNonImportant(field) == removeNonImportant(other.field)
  }

}

