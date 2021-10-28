package be.frol.chaman.mapper

import be.frol.chaman.model.{RichField, UserInfo}
import be.frol.chaman.openapi.model.{Item, ItemDescr, Link}
import be.frol.chaman.tables.Tables.{AnnexRow, DataRow, FieldRow, ItemRow, LinkRow}
import be.frol.chaman.utils.DateUtils
import be.frol.chaman.utils.OptionUtils.enrichedObject

import java.util.UUID

object ItemMapper {

  def toDto(itemRow: ItemRow, fields: Seq[RichField] = Nil, annexes: Seq[AnnexRow] = Nil, links: Seq[(LinkRow, ItemRow)] = Nil): Item = {
    new Item(itemRow.uuid.toOpt(),
      itemRow.title.toOpt(),
      itemRow.description.toOpt(),
      fields.map(FieldMapper.toDto(_)).toList.toOpt(),
      annexes.map(AnnexMapper.toDto(_)).toList.toOpt,
      links.map(v => LinkMapper.toDto(v)).toList.toOpt
    )

  }
  def toDtoFD(itemRow: ItemRow, fields: Seq[FieldRow], data:Seq[DataRow], annexes: Seq[AnnexRow], links: Seq[(LinkRow, ItemRow)]): Item = {
    val dataMap = data.groupBy(_.fieldUuid)
    toDto(itemRow, fields.map(f => RichField(f, dataMap.get(f.uuid).toList.flatten)), annexes, links)
  }

  def toDescrDto(itemRow: ItemRow): ItemDescr = {
    new ItemDescr(itemRow.uuid.toOpt(),
      itemRow.title.toOpt(),
      itemRow.description.toOpt(),
    )
  }



  def toRow(item: Item)(implicit userInfo: UserInfo) = {
    new ItemRow(0L, item.uuid.getOrElse(UUID.randomUUID().toString), item.title.getOrElse(""), item.description.getOrElse(""), userInfo.uuid, DateUtils.ts)
  }

  def toDataRow(item: Item)(implicit userInfo: UserInfo) = {
    item.content.map(_.flatMap(FieldMapper.toDataRows(_, item.uuid.get))).getOrElse(Nil)
  }
}
