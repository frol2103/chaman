package be.frol.chaman.service

import be.frol.chaman.api.DbContext
import be.frol.chaman.model.UserInfo
import be.frol.chaman.tables.Tables
import be.frol.chaman.utils.DateUtils
import play.api.db.slick.DatabaseConfigProvider

import javax.inject.Inject
import scala.concurrent.ExecutionContext

class TagService @Inject()(
                             val dbConfigProvider: DatabaseConfigProvider,
                           ) extends DbContext {


  import api._

  def add(p: Tables.FieldTagRow) = {
    ((Tables.FieldTag returning Tables.FieldTag.map(_.id)
      into ((v, id) => v.copy(id = id))) += p)
  }

  def find(fieldId:String) = Tables.FieldTag.filter(_.fieldUuid === fieldId).result

}
