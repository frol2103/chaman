package be.frol.chaman.mapper

import be.frol
import be.frol.chaman
import be.frol.chaman.core.field.DefaultFields
import be.frol.chaman.mapper.ItemMapper.toDescrDto
import be.frol.chaman.model.UserInfo
import be.frol.chaman.openapi.model.Link
import be.frol.chaman.tables
import be.frol.chaman.tables.Tables
import be.frol.chaman.tables.Tables.{DataRow, ItemRow, LinkRow}
import be.frol.chaman.utils.DateUtils
import be.frol.chaman.utils.OptionUtils.enrichedObject

import java.util.UUID
object LinkMapper {
  def toRow(uuid: String, linkedUuid: String)(implicit user:UserInfo): LinkRow =
  new LinkRow(0L,UUID.randomUUID().toString,uuid, linkedUuid,user.uuid, DateUtils.ts)


  def toDto(l:LinkRow, i:ItemRow, dataMap: Map[String, Iterable[DataRow]]) : Link = new Link(l.uuid.toOpt(), toDescrDto(i).toOpt(),
    DefaultFields.LinkFields.fields.map(f=>FieldMapper.toDto(f, l.uuid, dataMap)).toOpt())

  def toDto(r : (LinkRow, ItemRow), dataMap: Map[String, Iterable[DataRow]]): Link = toDto(r._1, r._2, dataMap)

}
