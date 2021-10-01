package be.frol.chaman.api

import be.frol.chaman.mapper.FieldMapper
import be.frol.chaman.openapi.api.{FieldApi, ItemApi}
import be.frol.chaman.openapi.model.{Field, Item}
import be.frol.chaman.service.FieldService
import be.frol.chaman.tables.Tables
import play.api.db.slick.DatabaseConfigProvider
import play.api.mvc.{AnyContent, ControllerComponents, Request}

import java.util.UUID
import javax.inject.Inject
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import be.frol.chaman.utils.OptionUtils._
import play.api.libs.json.Json
import be.frol.chaman.model.RichModelConversions._
import be.frol.chaman.tables
import slick.dbio.DBIOAction

class ItemApiImpl @Inject()(
                              val cc: ControllerComponents,
                              val dbConfigProvider: DatabaseConfigProvider,
                              val fieldService: FieldService,
                  ) extends ItemApi with DbContext {
  import api._

  override def createItem(item: Item)(implicit request: Request[AnyContent]): Future[Item] = ???

  override def deleteItem(uuid: String)(implicit request: Request[AnyContent]): Future[Unit] = ???

  override def getItem(uuid: String)(implicit request: Request[AnyContent]): Future[Item] = ???

  override def getItems()(implicit request: Request[AnyContent]): Future[List[Item]] = ???

  override def updateItem(uuid: String, item: Item)(implicit request: Request[AnyContent]): Future[Item] = ???
}
