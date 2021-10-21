package be.frol.chaman.service

import be.frol.chaman.api.DbContext
import be.frol.chaman.tables.Tables
import play.api.db.slick.DatabaseConfigProvider
import slick.util.Logging

import javax.inject.Inject

class ThumbnailService @Inject()(
                                  val dbConfigProvider: DatabaseConfigProvider,
                                  val fieldService: FieldService,
                                ) extends DbContext with Logging {


  import api._

  def add(p: Tables.ItemThumbnailRow) = {
    ((Tables.ItemThumbnail returning Tables.ItemThumbnail.map(_.id)
      into ((v, id) => v.copy(id = id))) += p)
  }

  def find(itemUuid: String) = lastVersion.filter(_.itemUuid === itemUuid).result.head

  val lastVersion = {
    Tables.ItemThumbnail.filterNot(f => Tables.ItemThumbnail.filter(_.itemUuid === f.itemUuid)
      .filter(_.id > f.id).exists)
  }
}
