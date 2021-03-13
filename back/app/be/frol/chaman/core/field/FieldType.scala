package be.frol.chaman.core.field

import play.api.libs.json.Format


case class FieldType[T](
                         identifier: String,
                         formatter: Format[T]
                       )
