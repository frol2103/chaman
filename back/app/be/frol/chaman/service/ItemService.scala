package be.frol.chaman.service

import be.frol.chaman.api.DbContext
import be.frol.chaman.openapi.model.Item
import be.frol.chaman.tables.Tables
import be.frol.chaman.utils.DateUtils
import play.api.db.slick.DatabaseConfigProvider
import slick.dbio.{DBIOAction, NoStream}

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class ItemService @Inject()(
                             val dbConfigProvider: DatabaseConfigProvider,
                           ) extends DbContext {


  import api._

  def add(p: Tables.ItemRow) = {
    ((Tables.Item returning Tables.Item.map(_.id)
      into ((v, id) => v.copy(id = id))) += p)
  }

  def delete(uuid: String) (implicit executionContext: ExecutionContext) = {
    lastVersion.filter(_.uuid === uuid).result.head.flatMap(v => Tables.ItemDeleted += Tables.ItemDeletedRow(0L, v.id, DateUtils.ts))
  }

  val lastVersion = {
    Tables.Item
      .filterNot(f => Tables.Item.filter(_.uuid === f.uuid)
      .filter(_.id > f.id).exists)
      .filterNot(f => Tables.ItemDeleted.filter(f.id === _.fkItemId).exists)
  }

  def all() = lastVersion.result

  def get(uuid: String) = lastVersion.filter(_.uuid === uuid).result.head
}
