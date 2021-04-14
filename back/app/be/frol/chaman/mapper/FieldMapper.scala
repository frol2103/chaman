package be.frol.chaman.mapper

import be.frol.chaman.model.RichField
import be.frol.chaman.openapi.model.Field
import be.frol.chaman.tables.Tables
import be.frol.chaman.utils.DateUtils
import be.frol.chaman.utils.OptionUtils._
import play.api.libs.json.{JsObject, Json}

import java.util.UUID

object FieldMapper {


  def toDto(f: RichField): Field = {
    Field(
      f.field.uuid.toOpt,
      f.field.label.toOpt,
      f.field.reference.toOpt,
      f.field.datatype.toOpt,
      f.serializedValue.map(v => JsObject(Seq("data" -> Json.parse(v)))),
      None,
    )
  }

  def toRow(f: Field) = {
    Tables.FieldRow(
      0L,
      f.uuid.map(_.toString).getOrElse(UUID.randomUUID().toString),
      f.reference.getOrThrowM("missing reference"),
      f.dataType.getOrThrowM("missing datatype"),
      f.label.getOrElse(""),
      f.value.flatMap(_.value.get("data").map(_.toString())),
      DateUtils.ts,
    )

  }

  def toDataRow(f: Field, referenceUuid:String) = {
    Tables.FieldDataRow(
      0L,
      f.uuid.get,
      referenceUuid,
      f.value.flatMap(_.value.get("data").map(_.toString())),
      DateUtils.ts,
    )
  }
}
