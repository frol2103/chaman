package be.frol.chaman.api

import be.frol.chaman.mapper.FieldMapper
import be.frol.chaman.openapi.api.FieldApi
import be.frol.chaman.openapi.model.Field
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

class FieldApiImpl @Inject()(
                              val cc: ControllerComponents,
                              val dbConfigProvider: DatabaseConfigProvider,
                              val fieldService: FieldService,
                  ) extends FieldApi with DbContext {
  import api._

  /**
   * create a field
   */
  override def createField(field: Field)(implicit request: Request[AnyContent]): Future[Field] = {
    db.run(
      fieldService.add(FieldMapper.toRow(field))
    ).map(FieldMapper.toDto(_))
  }

  /**
   * Get a field
   */
  override def getField()(implicit request: Request[AnyContent]): Future[List[Field]] = {
    db.run(fieldService.allFields)
      .map(_.map(FieldMapper.toDto(_)).toList)
  }

  /**
   * update a field
   */
  override def updateField(uuid: String, field: Field)(implicit request: Request[AnyContent]): Future[Field] = {
    val newField = FieldMapper.toRow(field).copy(uuid = uuid)

    def updateIfNeeded(f: tables.Tables.FieldRow) = {
      if (!f.equivalent(newField)) fieldService.add(newField.field)
      else DBIOAction.successful(f)
    }

    db.run(
      for{
        f <- fieldService.getField(uuid)
        nf <- updateIfNeeded(f)
      } yield(nf)
    ).map(FieldMapper.toDto(_))
  }

  /**
   * delete a field
   */
  override def deleteField(uuid: String)(implicit request: Request[AnyContent]): Future[Unit] = {
    db.run(this.fieldService.delete(uuid))
      .map(_ => Unit)
  }
}
