package be.frol.chaman.core.field

import be.frol.chaman.tables.Tables.FieldRow
import be.frol.chaman.utils.OptionUtils.enrichedOption
import play.api.libs.json.{JsObject, JsValue, Json}

trait FieldWithConf {
  def parseAndFormat(input: JsValue): JsValue = basicFieldType.parseAndFormat(input, config)

  def uuid: String

  def basicFieldType: BasicFieldType[_]

  def config: JsObject
}
object FieldWithConf {

  def toFieldWithConf(fr:FieldRow) = new FieldWithConf {
    override def uuid: String = fr.uuid

    override def basicFieldType: BasicFieldType[_] = FieldTypes.mapByInputType.get(fr.datatype).getOrThrowM("Field type " + fr.datatype + " not known").basicFieldType

    override def config: JsObject = fr.config.map(Json.parse(_)).map{
      case s:JsObject => s
      case _ => JsObject(Nil)
    }.getOrElse(JsObject(Nil))
  }
}
