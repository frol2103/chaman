package be.frol.chaman.service

import be.frol.chaman.api.DbContext
import be.frol.chaman.core.field.{ConfigFieldType, ConfigFieldTypes, DefaultFields, FieldWithConf, StaticFields}
import be.frol.chaman.model.RichModelConversions._
import be.frol.chaman.model.UserInfo
import be.frol.chaman.tables.Tables
import be.frol.chaman.tables.Tables.FieldRow
import be.frol.chaman.utils.DateUtils
import be.frol.chaman.utils.TraversableUtils.traversableEnriched
import play.api.Logging
import play.api.db.slick.DatabaseConfigProvider

import javax.inject.Inject
import scala.concurrent.ExecutionContext

class FieldService @Inject()(
                              val dbConfigProvider: DatabaseConfigProvider,
                            )(
                              implicit executionContext: ExecutionContext
                            ) extends DbContext with Logging{

  import api._

  def add(p: Tables.FieldRow) = {
    ((Tables.Field returning Tables.Field.map(_.id)
      into ((v, id) => v.copy(id = id))) += p)
  }

  def add(p: Tables.DataRow) = {
    ((Tables.Data returning Tables.Data.map(_.id)
      into ((v, id) => v.copy(id = id))) += p)
  }

  def addValues(v: Iterable[Tables.DataRow])(implicit executionContext: ExecutionContext) = {
    DBIO.sequence(v.map(add(_)))
  }

  def allFields = lastVersionOfFields.result

  def getField(uuid: String): DBIO[FieldRow] = DefaultFields.fieldsMap.get(uuid).map(DBIO.successful(_))
    .getOrElse(lastVersionOfFields.filter(_.uuid === uuid).result.head)

  def getDbFields(uuid: Iterable[String]): DBIO[Seq[FieldRow]] = {
    lastVersionOfFields.filter(_.uuid.inSet(uuid)).result
  }

  def getFieldsDefinition(uuids: List[String]): DBIO[Map[String, FieldWithConf]] = {
    val staticFields = StaticFields.allStaticFieldsMap.keySet.intersect(uuids.toSet)
    val remainingFields = uuids.toSet -- staticFields
    val staticFieldsConfig: Set[FieldWithConf] = staticFields.map(StaticFields.allStaticFieldsMap(_))
    (if (remainingFields.isEmpty) DBIO.successful(Nil) else getDbFields(remainingFields.toSeq).map(_.map(v=>FieldWithConf.toFieldWithConf(v.field)))).map(fl =>
      (fl ++ staticFieldsConfig).toMapBy(_.uuid)
    )
  }

  val lastVersionOfFields = {
    Tables.Field.filterNot(f => Tables.Field.filter(_.uuid === f.uuid).filter(_.id > f.id).exists)
      .filterNot(f => Tables.FieldDeleted.filter(f.id === _.fkFieldId).exists)
  }

  def delete(uuid: String)(implicit executionContext: ExecutionContext, userInfo: UserInfo) = {
    getField(uuid).flatMap(lv =>
      Tables.FieldDeleted += Tables.FieldDeletedRow(lv.id, userInfo.uuid, DateUtils.ts)
    )
  }
}

