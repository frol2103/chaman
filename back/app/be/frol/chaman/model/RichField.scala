package be.frol.chaman.model

import be.frol.chaman.core.field.{BasicFieldType, BasicFieldTypes, FieldTypes, FieldWithConf}
import be.frol.chaman.tables.Tables.{FieldDataRow, FieldRow}
import be.frol.chaman.utils.OptionUtils._
import play.api.Logging
import play.api.libs.json.{JsObject, Json}
import play.api.mvc.BodyParsers.utils

case class RichField(field: FieldRow, fieldData: Iterable[FieldDataRow]) extends Logging{
  def fieldUuid = field.uuid

  def toFieldWithConf = new FieldWithConf {
    override def uuid: String = fieldUuid

    override def basicFieldType: BasicFieldType[_] = FieldTypes.mapByInputType.get(field.datatype).getOrThrowM("Field type " + field.datatype + " not known").basicFieldType

    override def config: JsObject = field.config.map(Json.parse(_)).map{
      case s:JsObject => s
      case _ => JsObject(Nil)
    }.getOrElse(JsObject(Nil))
  }


  def equivalent(other: RichField) = {
    def removeNonImportant(f: FieldRow) = f.copy(id = 0L, timestamp = null)
    removeNonImportant(field) == removeNonImportant(other.field)
  }

}

