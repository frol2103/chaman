package be.frol.chaman.mapper

import be.frol.chaman.model.{RichField, UserInfo}
import be.frol.chaman.openapi.model.Item
import be.frol.chaman.tables.Tables.{AnnexRow, ItemRow}
import be.frol.chaman.utils.DateUtils
import be.frol.chaman.utils.OptionUtils.enrichedObject

import java.util.UUID

object ItemMapper {

  def toDto(itemRow: ItemRow, fields: Seq[RichField] = Nil, annexes:Seq[AnnexRow] = Nil) = {
    new Item(itemRow.uuid.toOpt(),
      itemRow.title.toOpt(),
      itemRow.description.toOpt(),
      fields.map(FieldMapper.toDto(_)).toList.toOpt(),
      annexes.map(AnnexMapper.toDto(_)).toList.toOpt)
  }

  def toRow(item: Item)(implicit userInfo: UserInfo) = {
    new ItemRow(0L,item.uuid.getOrElse(UUID.randomUUID().toString), item.title.getOrElse(""), item.description.getOrElse(""), userInfo.uuid, DateUtils.ts)
  }

  def toDataRow(item: Item) (implicit userInfo: UserInfo)= {
    item.content.map(_.flatMap(FieldMapper.toDataRows(_, item.uuid.get))).getOrElse(Nil)
  }
}
