package be.frol.chaman.core.field

import play.api.libs.json.{Format, JsNull, JsObject, JsValue, Json}
import be.frol.chaman.utils.TraversableUtils._

case class BasicFieldType[T](inputType: String, format: Format[T])

object BasicFieldTypes {

  val string = BasicFieldType("string", implicitly[Format[String]])
  val multipleString = BasicFieldType("multipleString", implicitly[Format[String]])
  val number = BasicFieldType("number", implicitly[Format[Int]])
  val multipleNumber = BasicFieldType("multipleNumber", implicitly[Format[Int]])
  val select = BasicFieldType("select", implicitly[Format[String]])
  val checkbox = BasicFieldType("checkbox", implicitly[Format[Boolean]])

}

case class ConfigFieldType[T](
                             uuid: String,
                               reference: String,
                              label: String,
                              basicFieldType: BasicFieldType[T],
                              config: JsObject = JsObject(Nil))

object ConfigFieldTypes {
  val suffix = ConfigFieldType("d889136c-75c1-4020-b89a-37d25b07eda4","suffix", "Suffix", BasicFieldTypes.string)
  val numberFormatter = ConfigFieldType("057c0520-59de-4a0f-a458-a40c3a6c96f1","number.formatter", "NumberFormatter", BasicFieldTypes.select,
    Json.toJsObject(Map("staticValues"-> List("none","metric prefix", "scientific"))))

  val staticValues = ConfigFieldType("057c0520-59de-4a0f-a458-a40c3a6c96f1","static.values", "Static Values", BasicFieldTypes.multipleString)

  val all = List(suffix, numberFormatter, staticValues)
  val mapUuid = all.toMapBy(_.uuid)
}

object FieldTypes {
  val string = FieldType(BasicFieldTypes.string, Nil)
  val multipleString = FieldType(BasicFieldTypes.multipleString, Nil)
  val number = FieldType(BasicFieldTypes.number, List(ConfigFieldTypes.suffix, ConfigFieldTypes.numberFormatter))
  val multipleNumber = FieldType(BasicFieldTypes.multipleNumber, List(ConfigFieldTypes.suffix, ConfigFieldTypes.numberFormatter))
  val select = FieldType(BasicFieldTypes.select, List(ConfigFieldTypes.staticValues))

  val all = List(string, multipleString, number, multipleNumber, select)
  val mapByInputType = all.toMapBy(_.basicFieldType.inputType)
}
