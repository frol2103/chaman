package be.frol.chaman.mapper

import be.frol.chaman.model.RichField
import be.frol.chaman.openapi.model.Item
import be.frol.chaman.tables.Tables.ItemRow
import be.frol.chaman.utils.DateUtils
import be.frol.chaman.utils.OptionUtils.enrichedObject

import java.util.UUID

object ItemMapper {

  def toDto(itemRow: ItemRow, fields: Seq[RichField] = Nil) = {
    new Item(itemRow.uuid.toOpt(), itemRow.title.toOpt(), itemRow.description.toOpt(), fields.map(FieldMapper.toDto(_)).toList.toOpt())
  }

  def toRow(item: Item) = {
    new ItemRow(0L,item.uuid.getOrElse(UUID.randomUUID().toString), item.title.getOrElse(""), item.description.getOrElse(""), DateUtils.ts)
  }

  def toDataRow(item: Item) = {
    item.content.map(_.flatMap(FieldMapper.toDataRows(_, item.uuid.get))).getOrElse(Nil)
  }
}
