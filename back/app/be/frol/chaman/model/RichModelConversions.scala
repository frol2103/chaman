package be.frol.chaman.model
import be.frol.chaman.tables.Tables._

object RichModelConversions {
  implicit def fieldToRichField(field:FieldRow) = new RichField(field)

}
