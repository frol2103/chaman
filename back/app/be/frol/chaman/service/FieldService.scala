package be.frol.chaman.service

import be.frol.chaman.api.DbContext
import be.frol.chaman.core.field.{ConfigFieldType, ConfigFieldTypes, FieldWithConf}
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

  def add(p: Tables.FieldDataRow) = {
    ((Tables.FieldData returning Tables.FieldData.map(_.id)
      into ((v, id) => v.copy(id = id))) += p)
  }

  def addValues(v: Iterable[Tables.FieldDataRow])(implicit executionContext: ExecutionContext) = {
    DBIO.sequence(v.map(add(_)))
  }

  def allFields = lastVersionOfFields.result

  def getField(uuid: String): DBIO[FieldRow] = lastVersionOfFields.filter(_.uuid === uuid).result.head

  def getFields(uuid: String*): DBIO[Seq[FieldRow]] = lastVersionOfFields.filter(_.uuid.inSet(uuid)).result

  def getFieldsDefinition(uuids: List[String]): DBIO[Map[String, FieldWithConf]] = {
    val staticFields = ConfigFieldTypes.mapUuid.keySet.intersect(uuids.toSet)
    val remainingFields = uuids.toSet -- staticFields
    val staticFieldsConfig: Set[ConfigFieldType[_]] = staticFields.map(ConfigFieldTypes.mapUuid(_))
    (if (remainingFields.isEmpty) DBIO.successful(Nil) else getFields(remainingFields.toSeq: _*).map(_.map(_.toFieldWithConf))).map( fl =>
      (fl ++ staticFieldsConfig).toMapBy(_.uuid)
    )
  }

  val lastVersionOfFields = {
    Tables.Field.filterNot(f => Tables.Field.filter(_.uuid === f.uuid).filter(_.id > f.id).exists)
      .filterNot(f => Tables.FieldDeleted.filter(f.id === _.fkFieldId).exists)
  }

  def delete(uuid: String)(implicit executionContext: ExecutionContext, userInfo: UserInfo) = {
    getField(uuid).flatMap(lv =>
      Tables.FieldDeleted += Tables.FieldDeletedRow(0L, lv.id, userInfo.uuid, DateUtils.ts)
    )
  }
}

