package be.frol.chaman.mapper

import be.frol.chaman.core.field.{DefaultFields, FieldWithConf}
import be.frol.chaman.model.{RichField, UserInfo}
import be.frol.chaman.openapi.model.{Item, ItemDescr, Link}
import be.frol.chaman.tables.Tables.{AnnexRow, DataRow, FieldRow, ItemRow, LinkRow}
import be.frol.chaman.utils.DateUtils
import be.frol.chaman.utils.OptionUtils.enrichedObject

import java.util.UUID

object ItemMapper {

  def toDtoFD(itemRow: ItemRow, fields: Seq[FieldWithConf], data:Seq[DataRow], annexes: Seq[AnnexRow], links: Seq[(LinkRow, ItemRow)]): Item = {
    val dataMap = data.groupBy(_.fieldUuid)
    new Item(itemRow.uuid.toOpt(),
      itemRow.title.toOpt(),
      itemRow.description.toOpt(),
      (DefaultFields.ItemContent.fields ++ fields).map(f => RichField(f, dataMap.get(f.uuid).toList.flatten)).map(FieldMapper.toDtoRf(_)).toList.toOpt(),
      annexes.map(AnnexMapper.toDto(_, dataMap)).toList.toOpt,
      links.map(v => LinkMapper.toDto(v, dataMap)).toList.toOpt
    )
  }

  def toDescrDto(itemRow: ItemRow): ItemDescr = {
    new ItemDescr(itemRow.uuid.toOpt(),
      itemRow.title.toOpt(),
      itemRow.description.toOpt(),
    )
  }




}
