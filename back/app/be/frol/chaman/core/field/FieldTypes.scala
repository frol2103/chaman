package be.frol.chaman.core.field

import be.frol.chaman.utils.JsonUtils.richJsResult
import be.frol.chaman.utils.OptionUtils.enrichedObject
import play.api.libs.json.{Format, JsArray, JsBoolean, JsNull, JsNumber, JsObject, JsString, JsValue, Json}
import be.frol.chaman.utils.TraversableUtils._
import play.api.{Logger, Logging}

case class BasicFieldType[T](inputType: String, format: Format[T], directValueF : List[T] => JsValue) {
  def directValue(v : List[JsValue]) = {
    val values = v.map(v => format.reads(v).getOrThrow(v.toOpt))
    directValueF(values)
  }
}

object BasicFieldTypes {
  private def list[T](f:T=>JsValue) = {l : List[T] =>
    JsArray(l.map(f))
  }

  private def single[T](f:T=>JsValue) = {l : List[T] =>
    l.headOption.map(f(_)).getOrElse(JsNull)
  }

  val string = BasicFieldType[String]("string", implicitly[Format[String]], single(JsString(_)))
  val multipleString = BasicFieldType[String]("multipleString", implicitly[Format[String]], list(JsString(_)))
  val number = BasicFieldType[Double]("number", implicitly[Format[Double]], single(JsNumber(_)))
  val multipleNumber = BasicFieldType[Double]("multipleNumber", implicitly[Format[Double]], list(JsNumber(_)))
  val select = BasicFieldType[String]("select", implicitly[Format[String]], single(JsString(_)))
  val checkbox = BasicFieldType[Boolean]("checkbox", implicitly[Format[Boolean]], single(JsBoolean(_)))

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

  val staticValues = ConfigFieldType("fbcec130-4d2d-420e-a5a3-caea9568828b","static.values", "Static Values", BasicFieldTypes.multipleString)

  val all : List[ConfigFieldType[_]]= List(suffix, numberFormatter, staticValues)
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
