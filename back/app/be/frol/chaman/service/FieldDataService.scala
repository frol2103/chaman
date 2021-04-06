package be.frol.chaman.service

import be.frol.chaman.api.DbContext
import be.frol.chaman.model.RichField
import be.frol.chaman.tables.Tables
import play.api.db.slick.DatabaseConfigProvider

import javax.inject.Inject
import scala.concurrent.ExecutionContext

class FieldDataService @Inject()(
                                  val dbConfigProvider: DatabaseConfigProvider,
                                  val fieldService: FieldService,
                                ) extends DbContext {

  import api._

  def add(p: Tables.FieldDataRow) = {
    ((Tables.FieldData returning Tables.FieldData.map(_.id)
      into ((v, id) => v.copy(id = id))) += p)
  }

  val lastVersion = {
    Tables.FieldData.filterNot(f => Tables.FieldData.filter(_.fieldUuid === f.fieldUuid)
      .filter(_.referenceUuid === f.referenceUuid)
      .filter(_.id > f.id).exists)
  }


  def fieldsFor(uuid:String) (implicit executionContext: ExecutionContext)= {
    lastVersion.filter(_.referenceUuid === uuid)
      .join(fieldService.lastVersionOfFields).on(_.fieldUuid === _.uuid)
      .result
      .map(_.map(RichField(_)))
  }


  def updateFields(current: Map[String,RichField],target: List[RichField]) = {
    Tables.FieldData ++= target.filter(t => !current.contains(t.fieldUuid) || !current(t.fieldUuid).equivalent(t)).map(_.fieldData).flatten
  }

}
