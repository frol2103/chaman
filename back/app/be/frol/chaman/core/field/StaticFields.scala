package be.frol.chaman.core.field

import be.frol.chaman.utils.TraversableUtils._

object StaticFields {

  def allStaticFields = DefaultFields.fields.map(v => FieldWithConf.toFieldWithConf(v)) ::: ConfigFieldTypes.all
  def allStaticFieldsMap = allStaticFields.toMapBy(_.uuid)

}
