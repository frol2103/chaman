package be.frol.chaman.core.field

import play.api.libs.json.{Format, JsNull, JsObject, JsValue, Json}

case class BasicFieldType[T](inputType: String, format: Format[T])

object BasicFieldTypes {

  val string = BasicFieldType("string", implicitly[Format[String]])
  val multipleString = BasicFieldType("multipleString", implicitly[Format[String]])
  val number = BasicFieldType("number", implicitly[Format[Int]])
  val multipleNumber = BasicFieldType("multipleNumber", implicitly[Format[Int]])
  val select = BasicFieldType("select", implicitly[Format[String]])
  val checkbox = BasicFieldType("checkbox", implicitly[Format[Boolean]])

}

case class ConfigFieldType[T](reference: String,
                              label: String,
                              basicFieldType: BasicFieldType[T],
                              config: JsObject = JsObject(Nil))

object ConfigFieldTypes {
  val suffix = ConfigFieldType("suffix", "Suffix", BasicFieldTypes.string)
  val numberFormatter = ConfigFieldType("number.formatter", "NumberFormatter", BasicFieldTypes.select,
    Json.toJsObject(Map("staticValues"-> List("none","metric prefix", "scientific"))))

  val staticValues = ConfigFieldType("static.values", "Static Values", BasicFieldTypes.multipleString)
}

object FieldTypes {
  val string = FieldType(BasicFieldTypes.string, Nil)
  val multipleString = FieldType(BasicFieldTypes.multipleString, Nil)
  val number = FieldType(BasicFieldTypes.number, List(ConfigFieldTypes.suffix, ConfigFieldTypes.numberFormatter))
  val multipleNumber = FieldType(BasicFieldTypes.multipleNumber, List(ConfigFieldTypes.suffix, ConfigFieldTypes.numberFormatter))
  val select = FieldType(BasicFieldTypes.select, List(ConfigFieldTypes.staticValues))

  val all = List(string, multipleString, number, multipleNumber, select)
}
