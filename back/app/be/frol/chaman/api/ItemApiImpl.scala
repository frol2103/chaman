package be.frol.chaman.api

import be.frol.chaman.core.field.DefaultFields
import be.frol.chaman.mapper.{FieldMapper, ItemMapper}
import be.frol.chaman.model.RichModelConversions._
import be.frol.chaman.openapi.api.ItemApi
import be.frol.chaman.openapi.model.{Field, Item, ItemDescr}
import be.frol.chaman.service.{AnnexService, DataService, FieldService, FieldValidationService, ItemRefresherService, ItemService, LinkService}
import be.frol.chaman.tables
import be.frol.chaman.tables.Tables
import be.frol.chaman.tables.Tables.DataDeletedRow
import be.frol.chaman.utils.DateUtils
import be.frol.chaman.utils.OptionUtils._
import play.api.db.slick.DatabaseConfigProvider
import play.api.mvc.{AnyContent, ControllerComponents, Request}

import java.util.UUID
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
                             val linkService: LinkService,
                             val fieldService: FieldService,
                             val itemRefresher: ItemRefresherService,
                           ) extends ItemApi with DbContext with ParentController {

  import api._

  override def createItem()(implicit request: Request[AnyContent]): Future[ItemDescr] = run { implicit u =>
    db.run(
      for {
        i <- itemService.add(new tables.Tables.ItemRow(0L, UUID.randomUUID().toString, "", "", u.uuid, DateUtils.ts))
      } yield (ItemMapper.toDescrDto(i))
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
      data <- fieldDataService.dataFor(Seq(uuid)).result
      fields <- fieldService.getDbFields(data.map(_.fieldUuid).toSet)
      annexes <- annexService.forItem(uuid)
      links <- linkService.getLinks(uuid)
    } yield{
      ItemMapper.toDtoFD(i, fields.map(fieldToFieldWithConf), data, annexes, links)
    }

  }

  private def getSavedField(ownerUuid: String, fieldUuid:String) = {
    fieldDataService.fieldFor(ownerUuid, fieldUuid)
      .map(f => FieldMapper.toDtoRf(f))
  }

  override def getItems()(implicit request: Request[AnyContent]): Future[List[ItemDescr]] =  run { implicit u =>
    db.run(itemService.all()).map(_.map(ItemMapper.toDescrDto(_)).toList)
  }

  override def deleteItemField(uuid: String, uuidField: String)(implicit request: Request[AnyContent]): Future[Unit] = run { implicit user =>
    db.run(fieldDataService.fieldData(uuid, uuidField).result.flatMap(l => fieldDataService.updateFieldValues(l, Nil)))
      .map(_ => None)
  }


  override def updateItemField(uuid: String, uuidField: String, field: Field, subReferenceUuid: Option[String])(implicit request:Request[AnyContent]): Future[Field] = run { implicit user =>
    import api._
    db.run(
      (for {
        validatedField <- fieldValidationService.assertValidField(field)
        currentData <- fieldDataService.fieldData(uuid, uuidField, subReferenceUuid).result
        newFields <- fieldDataService.updateFieldValues(currentData, FieldMapper.toDataRows(validatedField, uuid,subReferenceUuid))
        upd <- itemRefresher.refresh(uuid)
        field <- getSavedField(uuid, uuidField)
      } yield(field)).transactionally
    )
  }
}
