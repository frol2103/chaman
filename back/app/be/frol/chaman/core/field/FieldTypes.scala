package be.frol.chaman.core.field

import be.frol.chaman.openapi.model.FieldValue
import be.frol.chaman.utils.JsonUtils.richJsResult
import be.frol.chaman.utils.OptionUtils.enrichedObject
import play.api.libs.json.{Format, JsArray, JsBoolean, JsNull, JsNumber, JsObject, JsString, JsValue, Json}
import be.frol.chaman.utils.TraversableUtils._
import be.frol.chaman.utils.TryUtils.tryEnriched
import org.xhtmlrenderer.css.style.derived.NumberValue
import play.api.{Logger, Logging}

import scala.util.Try


trait Holder {
  def stringRepr : String
}

case class StringHolder(strValue:String) extends Holder{
  override def stringRepr: String = strValue
}
case class NumberHolder(strValue:String, processedValue: Option[Double]) extends Holder {
  val numericValue = Try{strValue.toDouble}.mapError(new RuntimeException("Number not readable : " + strValue)).get

  override def stringRepr: String = strValue
}
case class BooleanHolder(value:Boolean) extends Holder {
  override def stringRepr: String = value.toString
}

case class BasicFieldType[T <: Holder](
                              inputType: String,
                              format: Format[T],
                              directValueF : List[T] => JsValue,
                              formatter: (T => T) = (v:T) => v,
                            ) {
  def directValue(v : List[JsValue]) = {
    val values = v.map(v => format.reads(v).getOrThrow(v.toOpt))
    directValueF(values)
  }

  def value(v:JsValue) : Holder = v.validate(format).getOrThrow(v.toOpt())

  def parseAndFormat(input: JsValue, config:JsObject): JsValue= {
    if(input == JsNull) JsNull
    else {
      val value = format.reads(input).getOrThrowE(new RuntimeException("Error while reading data"))
      format.writes(formatter(value))
    }
  }
}

object BasicFieldTypes {
  private def list[T](f:T=>JsValue) = {l : List[T] =>
    JsArray(l.map(f))
  }

  private def single[T](f:T=>JsValue) = {l : List[T] =>
    l.headOption.map(f(_)).getOrElse(JsNull)
  }

  private def numberFormatter = (v:NumberHolder) =>v.copy(processedValue = v.numericValue.toOpt())

  val sHolderFormat = Json.format[StringHolder]
  val nHolderFormat = Json.format[NumberHolder]
  val bHolderFormat = Json.format[BooleanHolder]

  val multipleTag = BasicFieldType[StringHolder]("multipleTag", sHolderFormat, list(v =>JsString(v.strValue)))
  val string = BasicFieldType[StringHolder]("string", sHolderFormat, single(v =>JsString(v.strValue)))
  val multipleString = BasicFieldType[StringHolder]("multipleString", sHolderFormat, list(v => JsString(v.strValue)))
  val number = BasicFieldType[NumberHolder]("number", nHolderFormat, single(v => JsNumber(v.numericValue)), numberFormatter)
  val multipleNumber = BasicFieldType[NumberHolder]("multipleNumber", nHolderFormat, list(v=>JsNumber(v.numericValue)), numberFormatter)
  val select = BasicFieldType[StringHolder]("select", sHolderFormat, single(v => JsString(v.strValue)))
  val checkbox = BasicFieldType[BooleanHolder]("checkbox", bHolderFormat, single(v=>JsBoolean(v.value)))

}

case class ConfigFieldType[T <: Holder](
                             uuid: String,
                               reference: String,
                              label: String,
                              basicFieldType: BasicFieldType[T],
                              config: JsObject = JsObject(Nil)) extends FieldWithConf

object ConfigFieldTypes {
  val suffix = ConfigFieldType[StringHolder]("d889136c-75c1-4020-b89a-37d25b07eda4","suffix", "Suffix", BasicFieldTypes.string)
  val numberFormatter = ConfigFieldType("057c0520-59de-4a0f-a458-a40c3a6c96f1","number.formatter", "Number Formatter", BasicFieldTypes.select,
    Json.toJsObject(Map("staticValues"-> List("none","metric prefix", "scientific"))))

  val staticValues = ConfigFieldType("fbcec130-4d2d-420e-a5a3-caea9568828b","static.values", "Static Values", BasicFieldTypes.multipleString)

  val all : List[ConfigFieldType[_]]= List(suffix, numberFormatter, staticValues)
  val mapUuid = all.toMapBy(_.uuid)
}

object FieldTypes {
  val multipleTag = FieldType(BasicFieldTypes.multipleTag, Nil)
  val string = FieldType(BasicFieldTypes.string, Nil)
  val multipleString = FieldType(BasicFieldTypes.multipleString, Nil)
  val number = FieldType(BasicFieldTypes.number, List(ConfigFieldTypes.suffix, ConfigFieldTypes.numberFormatter))
  val multipleNumber = FieldType(BasicFieldTypes.multipleNumber, List(ConfigFieldTypes.suffix, ConfigFieldTypes.numberFormatter))
  val select = FieldType(BasicFieldTypes.select, List(ConfigFieldTypes.staticValues))

  val all = List(string, multipleString, number, multipleNumber, select, multipleTag)
  val mapByInputType = all.toMapBy(_.basicFieldType.inputType)
}
