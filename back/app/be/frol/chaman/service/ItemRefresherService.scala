package be.frol.chaman.service

import be.frol.chaman
import be.frol.chaman.api.DbContext
import be.frol.chaman.core.field.DefaultFields
import be.frol.chaman.model.UserInfo
import be.frol.chaman.tables
import be.frol.chaman.tables.Tables
import be.frol.chaman.utils.DateUtils
import be.frol.chaman.utils.OptionUtils.enrichedOption
import be.frol.chaman.utils.TraversableUtils.traversableEnriched
import play.api.db.slick.DatabaseConfigProvider

import javax.inject.Inject
import scala.concurrent.ExecutionContext
import be.frol.chaman.model.RichModelConversions._

class ItemRefresherService @Inject()(
                             val dbConfigProvider: DatabaseConfigProvider,
                             val fieldService: FieldService,
                             val dataService: DataService,
                             val itemService: ItemService,
                           )(
                             implicit executionContext: ExecutionContext,
                           ) extends DbContext {


  import api._



  def refresh(uuid:String)(implicit userInfo: UserInfo) = {
    for {
      item <- itemService.get(uuid)
      data <- dataService.dataFor(Seq(uuid)).result
      upd <- updateItem(item,data)
    } yield ()
  }

  def updateItem(item: Tables.ItemRow, data: Seq[Tables.DataRow])(implicit userInfo: UserInfo) = {
    val dataMap = data.groupBy(_.fieldUuid)
    val updatedItem = item.copy(
      title = DefaultFields.ItemContent.name.withData(dataMap).stringRepr,
      description = DefaultFields.ItemContent.description.withData(dataMap).stringRepr,
      author = userInfo.uuid,
      timestamp = DateUtils.ts)

    if (!item.baseEquivalent(updatedItem)) itemService.add(updatedItem) else DBIO.successful(item)
  }

}
