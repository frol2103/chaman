package be.frol.chaman.service

import be.frol.chaman.api.DbContext
import be.frol.chaman.error.ParentCycleError
import be.frol.chaman.model.{ParentGraph, RichField}
import be.frol.chaman.tables
import be.frol.chaman.tables.Tables
import be.frol.chaman.tables.Tables.{FieldRow, TemplateDeletedRow, TemplateParentRow}
import be.frol.chaman.utils.DateUtils
import play.api.db.slick.DatabaseConfigProvider

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}
import be.frol.chaman.mapper.TraversableUtils._
import be.frol.chaman.utils.OptionUtils._
import play.api.Logging



class TemplateService @Inject()(
                              val dbConfigProvider: DatabaseConfigProvider,
                              val fieldDataService: FieldDataService,
                            ) extends DbContext with Logging {
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

  def allParents(uuid: Seq[String], accumulators:ParentGraph=new ParentGraph())(implicit executionContext: ExecutionContext): DBIO[ParentGraph] ={
    val missing = accumulators.missingFor(uuid)
    if(missing.isEmpty) {
      DBIO.successful(accumulators)
    } else {
      Tables.TemplateParent
        .filter(t => t.childReference.inSet(missing))
        .filterNot(t => Tables.TemplateParentDeleted.filter(_.id === t.id).exists)
        .result
        .flatMap(m => allParents(uuid, accumulators.addLinksFor(missing.toSet, m)))
    }
  }

  def updateParents(template: String, current:Seq[TemplateParentRow], target:Set[String])(implicit executionContext: ExecutionContext) = {
    for{
      add <- Tables.TemplateParent ++= (target.toSet -- current.map(_.parentReference).toSet).map(parent => new TemplateParentRow(0L, parent,template, DateUtils.ts));
      remove <- Tables.TemplateParentDeleted ++= current.filterNot(c => target.contains(c.parentReference))
      .map(parent => new tables.Tables.TemplateParentDeletedRow(0L, parent.id, DateUtils.ts))
    } yield(add, remove)
  }

  def assertNoCycles(baseUuid:String,map:Map[String, Seq[TemplateParentRow]]):Unit ={
    def checkNoCycleFor(uuid:String) : Unit = {
      map(uuid).foreach(v => {
        if(v.parentReference == baseUuid) throw new ParentCycleError("Parent graph cannot have cycles")
        else checkNoCycleFor(v.parentReference)
      })
    }
    checkNoCycleFor(baseUuid)
  }

  def mergedFields(uuid:String, parentsGraph:ParentGraph)(implicit executionContext: ExecutionContext) ={
    fieldDataService.fieldsFor(parentsGraph.childrenCovered).map(_.groupBy(_.referenceUuid.get)).map(fields => {
      def mergedTemplateFields(templateUuid: String) : Map[String, RichField] = parentsGraph.parentsFor(templateUuid) match {
        case parents if parents.isEmpty => fields.get(templateUuid).getOrElse(Nil).toMapBy(_.fieldUuid)
        case parents => mergeFields(parents.map(p => mergedTemplateFields(p)).reduce(mergeFields), fields.get(templateUuid).getOrElse(Nil).toMapBy(_.fieldUuid))
      }
      mergedTemplateFields(uuid).values
    })

  }

  def mergeFields(parentFields : Map[String, RichField],childrenFields: Map[String, RichField] ): Map[String,RichField] = {
    parentFields.keySet.union(childrenFields.keySet)
      .map(key => key -> parentFields.get(key).map(_.merge(childrenFields.get(key))).getOrElse(childrenFields(key)))
      .toMap
  }

}
