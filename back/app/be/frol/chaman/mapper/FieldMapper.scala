package be.frol.chaman.mapper

import be.frol.chaman.core.field.{ConfigFieldType, ConfigFieldTypes, FieldType, FieldTypes}
import be.frol.chaman.model.{RichField, UserInfo}
import be.frol.chaman.openapi.model.{Field, FieldConfig, FieldValue}
import be.frol.chaman.tables
import be.frol.chaman.tables.Tables
import be.frol.chaman.tables.Tables.{FieldDataRow, FieldRow}
import be.frol.chaman.utils.DateUtils
import be.frol.chaman.utils.JsonUtils.richJsResult
import be.frol.chaman.utils.OptionUtils._
import play.api.libs.json.{JsObject, JsValue, Json}
import be.frol.chaman.utils.TraversableUtils._

import java.util.UUID

object FieldMapper {
  def toConfigDto(value: FieldType[_]): FieldConfig = {
    FieldConfig(None,None,
      value.basicFieldType.inputType.toOpt(),
      value.configFields.map(toDto(_)).toOpt()
    )
  }


  def toConfigDto(value: FieldRow, config:Seq[FieldDataRow]): FieldConfig = {
    val configDataMap = config.groupBy(_.fieldUuid)
    FieldConfig(
      value.label.toOpt(),
      value.reference.toOpt(),
      value.datatype.toOpt(),
      FieldTypes.mapByInputType(value.datatype).configFields.map{v => toDto(v)
        .copy(value = configDataMap.get(v.uuid).getOrElse(Nil).map(toDto(_)).toList.toOpt())}.toOpt()
    )
  }

  def toDto(f:ConfigFieldType[_]): Field = {
    Field(
      f.uuid.toOpt(),
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
      f.fieldData.map(v => toDto(v)).toList.toOpt(),
      f.field.config.map(Json.parse(_) match {
        case v : JsObject => v
        case _ => JsObject(Nil)
      })
    )
  }


  private def toDto(v: tables.Tables.FieldDataRow) = {
    FieldValue(v.valueUuid.toOpt(), v.value.map(v => Json.parse(v)))
  }

  def toRow(f: FieldConfig, uuid:Option[String])(implicit userInfo: UserInfo) = {
    Tables.FieldRow(
      0L,
      uuid.map(_.toString).getOrElse(UUID.randomUUID().toString),
      f.reference.getOrThrowM("missing reference"),
      f.datatype.getOrThrowM("missing datatype"),
      f.label.getOrElse(""),
      userInfo.uuid,
      DateUtils.ts,
      Json.toJsObject(toConfigMap(f.config.getOrElse(Nil))).toString().toOpt()
    )

  }

  def toConfigMap(fields : List[Field]) : Map[String, JsValue] = {
    fields.toMapBy(_.reference.getOrThrowM("Missing config field reference")).mapValues{f =>
      ConfigFieldTypes.mapUuid(f.uuid.getOrThrowM("Missing config field uuid")).basicFieldType.directValue(f.value.getOrElse(Nil).flatMap(_.value))
    }

  }

  def toDataRows(f: Field, ownerUuid: String)(implicit userInfo: UserInfo) = {
    f.value.getOrElse(Nil).map(v =>
      Tables.FieldDataRow(
        0L,
        f.uuid.get,
        ownerUuid,
        v.uuid.getOrElse(UUID.randomUUID().toString),
        v.value.map(_.toString),
        userInfo.uuid,
        DateUtils.ts,
      )
    )
  }
}
