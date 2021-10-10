package be.frol.chaman.service

import be.frol.chaman.api.DbContext
import be.frol.chaman.model.{RichField, UserInfo}
import be.frol.chaman.tables.Tables
import be.frol.chaman.tables.Tables.{FieldDataDeletedRow, FieldDataRow}
import be.frol.chaman.utils.DateUtils
import be.frol.chaman.utils.TraversableUtils.traversableEnriched
import play.api.db.slick.DatabaseConfigProvider
import slick.util.Logging

import javax.inject.Inject
import scala.concurrent.ExecutionContext

class FieldDataService @Inject()(
                                  val dbConfigProvider: DatabaseConfigProvider,
                                  val fieldService: FieldService,
                                ) extends DbContext with Logging {

  import api._

  def add(p: Tables.FieldDataRow) = {
    ((Tables.FieldData returning Tables.FieldData.map(_.id)
      into ((v, id) => v.copy(id = id))) += p)
  }


  val lastVersion = {
    Tables.FieldData.filterNot(f => Tables.FieldData.filter(_.fieldUuid === f.fieldUuid)
      .filter(_.ownerUuid === f.ownerUuid)
      .filter(_.valueUuid === f.valueUuid)
      .filter(_.id > f.id).exists)
      .filterNot(f => Tables.FieldDataDeleted.filter(f.id === _.fkFieldDataId).exists)
  }


  def fieldsFor(uuid: String)(implicit executionContext: ExecutionContext): DBIO[Seq[RichField]] = {
    fieldsFor(Seq(uuid))
  }


  def fieldsFor(uuid: Iterable[String])(implicit executionContext: ExecutionContext): DBIO[Seq[RichField]] = {
    lastVersion.filter(_.ownerUuid.inSet(uuid))
      .join(fieldService.lastVersionOfFields).on(_.fieldUuid === _.uuid)
      .result
      .map(_.groupBy(_._2)
        .map { case (f, values) => RichField(f, values.map(_._1)) }.toSeq)
  }

  def fieldDefaultData(uuids: Iterable[String]) = lastVersion.filter(f => f.fieldUuid === f.ownerUuid).filter(_.fieldUuid.inSet(uuids))

  def fieldData(ownerUuid: String, fieldUuid: String) = {
    lastVersion
      .filter(_.fieldUuid === fieldUuid)
      .filter(_.ownerUuid === ownerUuid)
  }

  def fieldDataRow(ownerUuid: String) = lastVersion.filter(_.ownerUuid === ownerUuid).result

  def updateFieldValues(current: Iterable[FieldDataRow], target: Iterable[FieldDataRow])(implicit executionContext: ExecutionContext, userInfo: UserInfo) = {
    val currentMap = current.toMapBy(_.valueUuid)
    val targetMap = target.toMapBy(_.valueUuid)
    val toDelete = currentMap.filterNot(c => targetMap.contains(c._1)).map(_._2).map(r => new FieldDataDeletedRow(0L, r.id,userInfo.uuid, DateUtils.ts))
    val toUpdate = target.filter(d => currentMap.get(d.valueUuid).map(d.value != _.value).getOrElse(true))
    val toUpdateMap = toUpdate.toMapBy(_.valueUuid)
    for {
      d <- Tables.FieldDataDeleted ++= toDelete
      upd <- Tables.FieldData ++= toUpdate
    } yield current.filterNot(c => toUpdateMap.contains(c.valueUuid)) ++ toUpdate
  }
}
