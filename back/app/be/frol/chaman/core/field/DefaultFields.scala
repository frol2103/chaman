package be.frol.chaman.core.field

import be.frol.chaman.tables.Tables.FieldRow
import be.frol.chaman.utils.TraversableUtils.traversableEnriched
import play.api.libs.json.{JsNull, JsObject}

import java.sql.Timestamp

object DefaultFields {
  def field(pUuid:String, ref:String, name:String, fieldTYpe: BasicFieldType[_]) = {
    new FieldWithConf {
      override def uuid: String = pUuid

      override def reference: String = ref

      override def label: String = name

      override def basicFieldType: BasicFieldType[_] = fieldTYpe

      override def config: JsObject = JsObject(Nil)
    }
  }

  object ItemContent {
    lazy val name = field("dcf5f7cc-9498-46e1-a2b8-b9560c1c669e","name", "Name", BasicFieldTypes.string)
    lazy val description = field("e78548bf-d6f2-4e6b-95c1-4f9d9ae9bbc0","description", "Description", BasicFieldTypes.string)
    lazy val references = field("d2e6e376-ec0d-41a6-bcaa-a79fda78f679","references", "References", BasicFieldTypes.multipleString)
    lazy val tags = field("e099fc09-1b64-47a1-9b3a-e54c6b2151cf","tags", "Tags", BasicFieldTypes.multipleTag)
    lazy val fields = List(name, description, references, tags)
  }

  object AnnexFields {
    lazy val tags = field("28e2ee6f-0232-4afc-9610-e1ac86f8b55a","tags.annex", "Tags", BasicFieldTypes.multipleTag)
    lazy val fields = List(tags)
  }

  object LinkFields{
    lazy val tags = field("5e572f41-625a-4521-afd3-0492f1133da5","tags.link", "Tags", BasicFieldTypes.multipleTag)
    lazy val fields = List(tags)
  }

  lazy val fields = ItemContent.fields ::: AnnexFields.fields ::: LinkFields.fields
  lazy val fieldsMap = fields.toMapBy(_.uuid)
}
