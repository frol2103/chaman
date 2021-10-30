package be.frol.chaman.mapper

import be.frol.chaman.core.field.DefaultFields
import be.frol.chaman.openapi.model.Annex
import be.frol.chaman.tables.Tables.{AnnexRow, DataRow}
import be.frol.chaman.utils.OptionUtils.enrichedObject

object AnnexMapper {
  def toDto(r: AnnexRow, dataMap:Map[String, Iterable[DataRow]]) = {
    Annex(
      r.uuid.toOpt,
      r.name.toOpt,
      r.mimetype.toOpt,
      DefaultFields.AnnexFields.fields.map(f=>FieldMapper.toDto(f, r.uuid, dataMap)).toOpt()
    )
  }
}
