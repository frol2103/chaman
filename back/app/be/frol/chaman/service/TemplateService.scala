package be.frol.chaman.service

import be.frol.chaman.api.DbContext
import be.frol.chaman.tables.Tables
import be.frol.chaman.tables.Tables.{FieldRow, TemplateDeletedRow}
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

  def delete(uuid: String)(implicit executionContext: ExecutionContext) = {
    find(uuid).flatMap(lv =>
      Tables.TemplateDeleted += TemplateDeletedRow(0L, lv.id, DateUtils.ts)
    )
  }



}
