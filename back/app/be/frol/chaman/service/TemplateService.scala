package be.frol.chaman.service

import be.frol.chaman.api.DbContext
import be.frol.chaman.tables
import be.frol.chaman.tables.Tables
import be.frol.chaman.tables.Tables.{FieldRow, TemplateDeletedRow, TemplateParentRow}
import be.frol.chaman.utils.DateUtils
import play.api.db.slick.DatabaseConfigProvider

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class TemplateService @Inject()(
                              val dbConfigProvider: DatabaseConfigProvider,
                            ) extends DbContext {
  import api._

  def add(p: Tables.TemplateRow) = {
    ((Tables.Template returning Tables.Template.map(_.id)
      into ((v, id) => v.copy(id = id))) += p)
  }

  val lastVersion = {
    Tables.Template.filterNot(f => Tables.Template.filter(_.uuid === f.uuid).filter(_.id > f.id).exists)
      .filterNot(f => Tables.TemplateDeleted.filter(f.id === _.fkTemplateId).exists)
  }

  def all() = lastVersion.result

  def find(uuid: String) = lastVersion.filter(_.uuid === uuid).result.head

  def find(uuid: Seq[String]) = lastVersion.filter(_.uuid.inSet(uuid)).result

  def delete(uuid: String)(implicit executionContext: ExecutionContext) = {
    find(uuid).flatMap(lv =>
      Tables.TemplateDeleted += TemplateDeletedRow(0L, lv.id, DateUtils.ts)
    )
  }

  def allParents(uuid: Seq[String], accumulators:Map[String,Seq[Tables.TemplateParentRow]]=Map())(implicit executionContext: ExecutionContext): DBIO[Map[String, Seq[Tables.TemplateParentRow]]] ={
    val missing = (accumulators.values.flatMap(_.map(_.childReference)).toSet ++ uuid.toSet) -- accumulators.keySet
    if(missing.isEmpty) {
      DBIO.successful(accumulators)
    } else {
      Tables.TemplateParent
        .filter(t => t.childReference.inSet(missing))
        .filterNot(t => Tables.TemplateParentDeleted.filter(_.id === t.id).exists)
        .result
        .map(l => l.groupBy(_.childReference))
        .map(map => map ++ (missing -- map.keySet).map(_ -> Seq()).toMap)
        .flatMap(allParents(uuid, _))
    }
  }

  def updateParents(template: String, current:Seq[TemplateParentRow], target:Set[String])(implicit executionContext: ExecutionContext) = {
    for{
      add <- Tables.TemplateParent ++= (target.toSet -- current.map(_.parentReference).toSet).map(parent => new TemplateParentRow(0L, parent,template, DateUtils.ts));
      remove <- Tables.TemplateParentDeleted ++= current.filterNot(c => target.contains(c.parentReference))
      .map(parent => new tables.Tables.TemplateParentDeletedRow(0L, parent.id, DateUtils.ts))
    } yield(add, remove)
  }


}
