package be.frol.chaman.service

import be.frol
import be.frol.chaman
import be.frol.chaman.api.DbContext
import be.frol.chaman.tables
import be.frol.chaman.tables.Tables
import be.frol.chaman.tables.Tables.{ItemRow, LinkRow}
import be.frol.chaman.utils.OptionUtils.enrichedOption
import be.frol.chaman.utils.TraversableUtils.traversableEnriched
import play.api.db.slick.DatabaseConfigProvider
import slick.dbio.DBIOAction
import slick.jdbc

import javax.inject.Inject
import scala.concurrent.ExecutionContext

class LinkService @Inject()(
                             val dbConfigProvider: DatabaseConfigProvider,
                             val itemService: ItemService,
                           )(
                             implicit executionContext: ExecutionContext
                           ) extends DbContext {


  import api._

  def add(p: Tables.LinkRow) = {
    ((Tables.Link returning Tables.Link.map(_.id)
      into ((v, id) => v.copy(id = id))) += p)
  }

  def getLinks(itemUuid: String): DBIO[Seq[(LinkRow, ItemRow)]] = {
    def otherItem(i:LinkRow) = if (i.itemUuid1 == itemUuid) i.itemUuid2 else i.itemUuid1;
    for {
      links <- currentLinks.filter(v => (v.itemUuid1 === itemUuid) || (v.itemUuid2 === itemUuid)).result
      items <- itemService.get(links.map(otherItem(_)).toSet).map(_.toMapBy(_.uuid))
    } yield links.map(l=> l -> items.get(otherItem(l)).getOrThrowM("Couldn't find item for link"))
  }

  val currentLinks = Tables.Link.filter(v => Tables.LinkRemoved.filter(_.fkLinkId === v.id).exists)

  def get(uuid: String)= currentLinks.filter(_.uuid === uuid).result.headOption.map(_.getOrThrowM("Cannot find item " + uuid))

  def delete(row: Tables.LinkRemovedRow) = Tables.LinkRemoved += row
}
