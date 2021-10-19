package be.frol.chaman.api

import be.frol.chaman.mapper.ItemMapper
import be.frol.chaman.model.RichModelConversions._
import be.frol.chaman.openapi.api.ItemApi
import be.frol.chaman.openapi.model.Item
import be.frol.chaman.service.{AnnexService, DataService, FieldValidationService, ItemService}
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
                             val fieldDataService: DataService,
                             val fieldValidationService: FieldValidationService,
                             val annexService:AnnexService,
                           ) extends ItemApi with DbContext with ParentController {

  import api._

  override def createItem(inputItem: Item)(implicit request: Request[AnyContent]): Future[Item] = run { implicit u =>
    db.run(
      for {
        validatedItem <- fieldValidationService.assertValidFieldsItem(inputItem)
        i <- itemService.add(ItemMapper.toRow(validatedItem))
        data <- fieldDataService.updateFieldValues(Nil, ItemMapper.toDataRow(validatedItem.copy(uuid = i.uuid.toOpt())))
        item <- getSavedItem(i.uuid)
      } yield (item)
    )
  }

  override def deleteItem(uuid: String)(implicit request: Request[AnyContent]): Future[Unit] = run { implicit u =>
    db.run(itemService.delete(uuid)).map(_ => None)
  }

  override def getItem(uuid: String)(implicit request: Request[AnyContent]): Future[Item] =  run { implicit u =>
    db.run(
      getSavedItem(uuid)
    )
  }

  private def getSavedItem(uuid: String) = {
    for {
      i <- itemService.get(uuid)
      fields <- fieldDataService.fieldsFor(uuid)
      annexes <- annexService.forItem(uuid)
    } yield ItemMapper.toDto(i, fields, annexes)
  }

  override def getItems()(implicit request: Request[AnyContent]): Future[List[Item]] =  run { implicit u =>
    db.run(itemService.all()).map(_.map(ItemMapper.toDto(_)).toList)
  }

  override def updateItem(uuid: String, inputItem: Item)(implicit request: Request[AnyContent]): Future[Item] =  run { implicit u =>
    def updateBaseIfNeeded(current: Tables.ItemRow) = {
      val target = ItemMapper.toRow(inputItem)
      if (target.baseEquivalent(current)) DBIO.successful(current)
      else itemService.add(target)
    }

    db.run(
      for {
        validatedItem <- fieldValidationService.assertValidFieldsItem(inputItem)
        currentItem <- itemService.get(uuid)
        currentFields <- fieldDataService.fieldDataRow(uuid)
        newBase <- updateBaseIfNeeded(currentItem)
        newFields <- fieldDataService.updateFieldValues(currentFields, ItemMapper.toDataRow(validatedItem))
        newItem <- getSavedItem(uuid)
      } yield (newItem)
    )
  }
}
