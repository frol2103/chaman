package be.frol.chaman.mapper

import be.frol.chaman.openapi.model.Annex
import be.frol.chaman.tables.Tables.AnnexRow
import be.frol.chaman.utils.OptionUtils.enrichedObject

object AnnexMapper {
  def toDto(r: AnnexRow) = {
    Annex(
      r.uuid.toOpt,
      r.name.toOpt,
      r.mimetype.toOpt,
    )
  }
}
