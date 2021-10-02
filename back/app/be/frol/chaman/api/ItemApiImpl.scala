package be.frol.chaman.api

import be.frol.chaman.mapper.ItemMapper
import be.frol.chaman.model.RichModelConversions._
import be.frol.chaman.openapi.api.ItemApi
import be.frol.chaman.openapi.model.Item
import be.frol.chaman.service.{FieldDataService, ItemService}
import be.frol.chaman.tables.Tables
import be.frol.chaman.utils.OptionUtils._
import play.api.db.slick.DatabaseConfigProvider
import play.api.mvc.{AnyContent, ControllerComponents, Request}

import javax.inject.Inject
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future


class ItemApiImpl @Inject()(
                             val cc: ControllerComponents,
                             val dbConfigProvider: DatabaseConfigProvider,
                             val itemService: ItemService,
                             val fieldDataService: FieldDataService,
                           ) extends ItemApi with DbContext {

  import api._

  override def createItem(item: Item)(implicit request: Request[AnyContent]): Future[Item] = {
    db.run(
      for {
        i <- itemService.add(ItemMapper.toRow(item))
        data <- fieldDataService.updateFieldValues(Nil, ItemMapper.toDataRow(item.copy(uuid = i.uuid.toOpt())))
        item <- getSavedItem(i.uuid)
      } yield (item)
    )
  }

  override def deleteItem(uuid: String)(implicit request: Request[AnyContent]): Future[Unit] = {
    db.run(itemService.delete(uuid)).map(_ => None)
  }

  override def getItem(uuid: String)(implicit request: Request[AnyContent]): Future[Item] = {
    db.run(
      getSavedItem(uuid)
    )
  }

  private def getSavedItem(uuid: String) = {
    for {
      i <- itemService.get(uuid)
      fields <- fieldDataService.fieldsFor(uuid)
    } yield ItemMapper.toDto(i, fields)
  }

  override def getItems()(implicit request: Request[AnyContent]): Future[List[Item]] = {
    db.run(itemService.all()).map(_.map(ItemMapper.toDto(_)).toList)
  }

  override def updateItem(uuid: String, item: Item)(implicit request: Request[AnyContent]): Future[Item] = {
    def updateBaseIfNeeded(current: Tables.ItemRow) = {
      val target = ItemMapper.toRow(item)
      if (target.baseEquivalent(current)) DBIO.successful(current)
      else itemService.add(target)
    }

    db.run(
      for {
        currentItem <- itemService.get(uuid)
        currentFields <- fieldDataService.fieldDataRow(uuid)
        newBase <- updateBaseIfNeeded(currentItem)
        newFields <- fieldDataService.updateFieldValues(currentFields, ItemMapper.toDataRow(item))
        newItem <- getSavedItem(uuid)
      } yield (newItem)
    )
  }
}
