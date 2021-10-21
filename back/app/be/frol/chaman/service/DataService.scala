package be.frol.chaman.service

import be.frol.chaman.api.DbContext
import be.frol.chaman.model.{RichField, UserInfo}
import be.frol.chaman.tables.Tables
import be.frol.chaman.tables.Tables.{DataDeletedRow, DataRow}
import be.frol.chaman.utils.DateUtils
import be.frol.chaman.utils.TraversableUtils.traversableEnriched
import play.api.db.slick.DatabaseConfigProvider
import slick.util.Logging

import javax.inject.Inject
import scala.concurrent.ExecutionContext

class DataService @Inject()(
                                  val dbConfigProvider: DatabaseConfigProvider,
                                  val fieldService: FieldService,
                                ) extends DbContext with Logging {

  import api._

  def add(p: Tables.DataRow) = {
    ((Tables.Data returning Tables.Data.map(_.id)
      into ((v, id) => v.copy(id = id))) += p)
  }


  val lastVersion = {
    Tables.Data.filterNot(f => Tables.Data.filter(_.fieldUuid === f.fieldUuid)
      .filter(_.ownerUuid === f.ownerUuid)
      .filter(_.valueUuid === f.valueUuid)
      .filter(_.id > f.id).exists)
      .filterNot(f => Tables.DataDeleted.filter(f.id === _.fkFieldDataId).exists)
  }


  def fieldsFor(uuid: String)(implicit executionContext: ExecutionContext): DBIO[Seq[RichField]] = {
    fieldsFor(Seq(uuid))
  }


  def fieldsFor(uuid: Iterable[String])(implicit executionContext: ExecutionContext): DBIO[Seq[RichField]] = {
    dataFor(uuid)
      .join(fieldService.lastVersionOfFields).on(_.fieldUuid === _.uuid)
      .result
      .map(_.groupBy(_._2)
        .map { case (f, values) => RichField(f, values.map(_._1)) }.toSeq)
  }

  def dataFor(uuid: Iterable[String]) = {
    lastVersion.filter(_.ownerUuid.inSet(uuid))
  }

  def fieldData(ownerUuid: String, fieldUuid: String) = {
    lastVersion
      .filter(_.fieldUuid === fieldUuid)
      .filter(_.ownerUuid === ownerUuid)
  }

  def fieldDataRow(ownerUuid: String) = lastVersion.filter(_.ownerUuid === ownerUuid).result

  def updateFieldValuesMaps(current: Map[String, Iterable[DataRow]], target: Map[String, Iterable[DataRow]])(implicit executionContext: ExecutionContext, userInfo: UserInfo)=  {
    DBIO.sequence((current.keySet union target.keySet).map(v => updateFieldValues(current.get(v).getOrElse(Nil), target.get(v).getOrElse(Nil))).toList)
      .map(_.flatten)
  }

  def updateFieldValues(current: Iterable[DataRow], target: Iterable[DataRow])(implicit executionContext: ExecutionContext, userInfo: UserInfo) = {
    val currentMap = current.toMapBy(_.valueUuid)
    val targetMap = target.toMapBy(_.valueUuid)
    val toDelete = currentMap.filterNot(c => targetMap.contains(c._1)).map(_._2).map(r => new DataDeletedRow( r.id,userInfo.uuid, DateUtils.ts))
    val toUpdate = target.filter(d => currentMap.get(d.valueUuid).map(d.value != _.value).getOrElse(true))
    val toUpdateMap = toUpdate.toMapBy(_.valueUuid)
    for {
      d <- Tables.DataDeleted ++= toDelete
      upd <- Tables.Data ++= toUpdate
    } yield current.filterNot(c => toUpdateMap.contains(c.valueUuid)) ++ toUpdate
  }
}
