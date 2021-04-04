package be.frol.chaman.service

import be.frol.chaman.api.DbContext
import be.frol.chaman.tables.Tables
import play.api.db.slick.DatabaseConfigProvider

import javax.inject.Inject

class FieldDataService @Inject()(
                                  val dbConfigProvider: DatabaseConfigProvider,
                                ) extends DbContext {

  import api._

  def add(p: Tables.FieldDataRow) = {
    ((Tables.FieldData returning Tables.FieldData.map(_.id)
      into ((v, id) => v.copy(id = id))) += p)
  }

}
