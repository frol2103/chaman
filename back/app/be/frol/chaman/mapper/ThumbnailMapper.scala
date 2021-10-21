package be.frol.chaman.mapper

import be.frol.chaman.openapi.model.Thumbnail
import be.frol.chaman.tables.Tables
import be.frol.chaman.utils.OptionUtils.enrichedObject

object ThumbnailMapper {

  def toDto(t : Tables.ItemThumbnailRow) = {
    new Thumbnail(
      t.annexUuid.toOpt(),
      BigDecimal(t.x).toOpt(),
      BigDecimal(t.y).toOpt(),
      BigDecimal(t.width).toOpt(),
    )
  }

}
