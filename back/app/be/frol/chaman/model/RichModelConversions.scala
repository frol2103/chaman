package be.frol.chaman.model
import be.frol.chaman.core.field.FieldWithConf
import be.frol.chaman.tables.Tables._

object RichModelConversions {
  implicit def fieldToFieldWithConf(field:FieldRow) = FieldWithConf.toFieldWithConf(field)
  implicit def fieldToRichField(field:FieldRow) = new RichField(FieldWithConf.toFieldWithConf(field),Nil)
  implicit def fieldToRichField(field:FieldWithConf) = new RichField(field,Nil)
  implicit def itemToRichItem(item:ItemRow) = new RichItem(item, Nil)

}
