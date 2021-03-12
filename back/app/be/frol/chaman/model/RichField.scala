package be.frol.chaman.model

import be.frol.chaman.tables.Tables.FieldRow

class RichField(field: FieldRow) {
  def equivalent(other:FieldRow) = {
    def removeNonImportant(f:FieldRow) = f.copy(id = 0L, timestamp = null)
    removeNonImportant(field) == removeNonImportant(other)
  }
}

