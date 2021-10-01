package be.frol.chaman.mapper

import be.frol.chaman.model.RichField
import be.frol.chaman.openapi.model.{Field, FieldValue}
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
      f.fieldData.map(v => FieldValue(v.valueUuid.toOpt(), v.value.map(v => JsObject(Map("data" -> Json.parse(v)))))).toList.toOpt()
    )
  }


  def toRow(f: Field) = {
    Tables.FieldRow(
      0L,
      f.uuid.map(_.toString).getOrElse(UUID.randomUUID().toString),
      f.reference.getOrThrowM("missing reference"),
      f.dataType.getOrThrowM("missing datatype"),
      f.label.getOrElse(""),
      DateUtils.ts,
    )

  }

  def toDataRows(f: Field, ownerUuid: String) = {
    f.value.getOrElse(Nil).map(v =>
      Tables.FieldDataRow(
        0L,
        f.uuid.get,
        ownerUuid,
        v.uuid.getOrElse(UUID.randomUUID().toString),
        v.value.flatMap(o => o.value.get("data").map(_.toString())),
        DateUtils.ts,
      )
    )
  }
}
