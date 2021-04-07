package be.frol.chaman.service

import be.frol.chaman.api.DbContext
import be.frol.chaman.tables.Tables
import be.frol.chaman.tables.Tables.FieldRow
import play.api.db.slick.DatabaseConfigProvider

import javax.inject.Inject

class FieldService @Inject()(
                              val dbConfigProvider: DatabaseConfigProvider,
                            ) extends DbContext {
  import api._

  def add(p: Tables.FieldRow) = {
    ((Tables.Field returning Tables.Field.map(_.id)
      into ((v, id) => v.copy(id = id))) += p)
  }

  def allFields = lastVersionOfFields.result

  def getField(uuid:String) : DBIO[FieldRow]= lastVersionOfFields.filter(_.uuid === uuid).result.head

  def getFields(uuid:String*) : DBIO[Seq[FieldRow]]= lastVersionOfFields.filter(_.uuid.inSet(uuid)).result

  val lastVersionOfFields = {
    Tables.Field.filterNot(f => Tables.Field.filter(_.uuid === f.uuid).filter(_.id > f.id).exists)
      .filterNot(f => Tables.FieldDeleted.filter(f.id === _.fkFieldId).exists)
  }
}

