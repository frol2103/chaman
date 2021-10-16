package be.frol.chaman.core.field

import play.api.libs.json.Format


case class FieldType[T](
                       basicFieldType: BasicFieldType[T],
                       configFields: List[ConfigFieldType[_]]
                       )
