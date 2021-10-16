package be.frol.chaman.mapper

import be.frol.chaman.core.field.{ConfigFieldType, FieldType}
import be.frol.chaman.model.{RichField, UserInfo}
import be.frol.chaman.openapi.model.{Field, FieldConfig, FieldValue}
import be.frol.chaman.tables.Tables
import be.frol.chaman.utils.DateUtils
import be.frol.chaman.utils.OptionUtils._
import play.api.libs.json.{JsObject, Json}

import java.util.UUID

object FieldMapper {
  def toConfigDto(value: FieldType[_]): FieldConfig = {
    FieldConfig(None,None,
      value.basicFieldType.inputType.toOpt(),
      value.configFields.map(toDto(_)).toOpt()
    )
  }

  def toDto(f:ConfigFieldType[_]): Field = {
    Field(
      None,
      f.label.toOpt(),
      f.reference.toOpt(),
      f.basicFieldType.inputType.toOpt(),
      None,
      f.config.toOpt(),
    )
  }

  def toDto(f: RichField): Field = {
    Field(
      f.field.uuid.toOpt,
      f.field.label.toOpt,
      f.field.reference.toOpt,
      f.field.datatype.toOpt,
      f.fieldData.map(v => FieldValue(v.valueUuid.toOpt(), v.value.map(v => JsObject(Map("data" -> Json.parse(v)))))).toList.toOpt(),
      None
    )
  }


  def toRow(f: Field)(implicit userInfo: UserInfo) = {
    Tables.FieldRow(
      0L,
      f.uuid.map(_.toString).getOrElse(UUID.randomUUID().toString),
      f.reference.getOrThrowM("missing reference"),
      f.inputType.getOrThrowM("missing datatype"),
      f.label.getOrElse(""),
      userInfo.uuid,
      DateUtils.ts,
    )

  }

  def toDataRows(f: Field, ownerUuid: String)(implicit userInfo: UserInfo) = {
    f.value.getOrElse(Nil).map(v =>
      Tables.FieldDataRow(
        0L,
        f.uuid.get,
        ownerUuid,
        v.uuid.getOrElse(UUID.randomUUID().toString),
        v.value.flatMap(o => o.value.get("data").map(_.toString())),
        userInfo.uuid,
        DateUtils.ts,
      )
    )
  }
}
