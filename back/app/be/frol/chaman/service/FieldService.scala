package be.frol.chaman.service

import be.frol.chaman.api.DbContext
import be.frol.chaman.model.UserInfo
import be.frol.chaman.tables.Tables
import be.frol.chaman.tables.Tables.{FieldDataDeletedRow, FieldRow}
import be.frol.chaman.utils.DateUtils
import play.api.db.slick.DatabaseConfigProvider
import slick.dbio.{DBIOAction, NoStream}

import javax.inject.Inject
import scala.concurrent.ExecutionContext

class FieldService @Inject()(
                              val dbConfigProvider: DatabaseConfigProvider,
                            ) extends DbContext {

  import api._

  def add(p: Tables.FieldRow) = {
    ((Tables.Field returning Tables.Field.map(_.id)
      into ((v, id) => v.copy(id = id))) += p)
  }

  def add(p: Tables.FieldDataRow) = {
    ((Tables.FieldData returning Tables.FieldData.map(_.id)
      into ((v, id) => v.copy(id = id))) += p)
  }

  def addValues(v : Iterable[Tables.FieldDataRow])(implicit executionContext: ExecutionContext) ={
    DBIO.sequence(v.map(add(_)))
  }

  def allFields = lastVersionOfFields.result

  def getField(uuid:String) : DBIO[FieldRow]= lastVersionOfFields.filter(_.uuid === uuid).result.head

  def getFields(uuid:String*) : DBIO[Seq[FieldRow]]= lastVersionOfFields.filter(_.uuid.inSet(uuid)).result

  val lastVersionOfFields = {
    Tables.Field.filterNot(f => Tables.Field.filter(_.uuid === f.uuid).filter(_.id > f.id).exists)
      .filterNot(f => Tables.FieldDeleted.filter(f.id === _.fkFieldId).exists)
  }

  def delete(uuid: String)(implicit executionContext: ExecutionContext, userInfo: UserInfo) = {
    getField(uuid).flatMap(lv =>
      Tables.FieldDeleted += Tables.FieldDeletedRow(0L, lv.id,userInfo.uuid, DateUtils.ts)
    )
  }
}

