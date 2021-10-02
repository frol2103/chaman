package be.frol.chaman.model

import be.frol.chaman.tables.Tables.{FieldDataRow, FieldRow, ItemRow}
import play.api.Logging

case class RichItem(row: ItemRow, fieldData: Iterable[FieldDataRow] = Nil) extends Logging{

  def baseEquivalent(other: RichItem) = {
    def removeNonImportant(f: ItemRow) = f.copy(id = 0L, timestamp = null)
    removeNonImportant(row) == removeNonImportant(other.row)
  }

}

