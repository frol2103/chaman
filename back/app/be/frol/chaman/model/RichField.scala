package be.frol.chaman.model

import be.frol.chaman.core.field.{BasicFieldType, BasicFieldTypes, FieldTypes, FieldWithConf}
import be.frol.chaman.tables.Tables.{DataRow, FieldRow}
import be.frol.chaman.utils.OptionUtils._
import play.api.Logging
import play.api.libs.json.{JsObject, Json}
import play.api.mvc.BodyParsers.utils

case class RichField(field: FieldRow, fieldData: Iterable[DataRow]) extends Logging{
  def fieldUuid = field.uuid
  lazy val fieldWithConf = FieldWithConf.toFieldWithConf(field)

  lazy val basicFieldType: BasicFieldType[_] = fieldWithConf.basicFieldType

  def withData(fieldData: Map[String,Iterable[DataRow]]) = copy(fieldData = fieldData.get(fieldUuid).toList.flatten)

  def stringRepr = values.map(_.stringRepr).mkString(",")

  def values = fieldData.flatMap(_.value).map(v => basicFieldType.value(Json.parse(v)))

  def equivalent(other: RichField) = {
    def removeNonImportant(f: FieldRow) = f.copy(id = 0L, timestamp = null)
    removeNonImportant(field) == removeNonImportant(other.field)
  }
}

