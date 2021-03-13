package be.frol.chaman.core.field

import play.api.libs.json.Format

object FieldTypes {
  val all = List(
    FieldType("String", implicitly[Format[String]]),
    FieldType("Integer", implicitly[Format[Int]]),
  )
}
