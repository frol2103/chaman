package be.frol.chaman.mapper

import be.frol.chaman.core.field.{ConfigFieldType, ConfigFieldTypes, FieldType, FieldTypes, FieldWithConf}
import be.frol.chaman.model.{RichField, UserInfo}
import be.frol.chaman.openapi.model.{Field, FieldConfig, FieldValue}
import be.frol.chaman.tables
import be.frol.chaman.tables.Tables
import be.frol.chaman.tables.Tables.{DataRow, FieldRow}
import be.frol.chaman.utils.DateUtils
import be.frol.chaman.utils.OptionUtils._
import be.frol.chaman.utils.TraversableUtils._
import play.api.libs.json.{JsObject, JsValue, Json}

import java.util.UUID
import be.frol.chaman.model.RichModelConversions._
import play.api.Logging
object FieldMapper extends Logging{
  def toConfigDto(value: FieldType[_]): FieldConfig = {
    FieldConfig(None, None,
      value.basicFieldType.inputType.toOpt(),
      value.configFields.map(toDto(_)).toOpt()
    )
  }


  def toConfigDto(value: FieldWithConf, config: Seq[DataRow]): FieldConfig = {
    val configDataMap = config.groupBy(_.fieldUuid)
    FieldConfig(
      value.label.toOpt(),
      value.reference.toOpt(),
      value.basicFieldType.inputType.toOpt(),
      FieldTypes.mapByInputType(value.basicFieldType.inputType).configFields.map { v =>
        toDto(v)
          .copy(value = configDataMap.get(v.uuid).getOrElse(Nil).map(toDto(_)).toList.toOpt())
      }.toOpt()
    )
  }

  def toDto(f: FieldWithConf): Field = toDtoRf(f)

  def toDto(field:FieldWithConf, subReferenceUuid:String , dataMap:Map[String, Iterable[DataRow]]):Field = {
    toDtoRf(field.withData(dataMap.get(field.uuid).getOrElse(Nil).filter(_.subreferenceUuid == Some(subReferenceUuid))))
  }

  def toDtoRf(f: RichField): Field = {
    Field(
      f.field.uuid.toOpt,
      f.field.label.toOpt,
      f.field.reference.toOpt,
      f.field.basicFieldType.inputType.toOpt,
      f.fieldData.map(v => toDto(v)).toList.toOpt(),
      f.field.config.toOpt(),
      None,
      f.field.isUserField.toOpt(),

    )
  }


  private def toDto(v: tables.Tables.DataRow) = {
    FieldValue(v.valueUuid.toOpt(), v.value.map(v => Json.parse(v)))
  }

  def toRow(f: FieldConfig, uuid: Option[String])(implicit userInfo: UserInfo) = {
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

  def toConfigMap(fields: List[Field]): Map[String, JsValue] = {
    fields.toMapBy(_.reference.getOrThrowM("Missing config field reference")).mapValues { f =>
      ConfigFieldTypes.mapUuid(f.uuid.getOrThrowM("Missing config field uuid")).basicFieldType.directValue(f.value.getOrElse(Nil).flatMap(_.value))
    }

  }

  def toDataRows(f: Field, ownerUuid: String, subreferenceUuid:Option[String])(implicit userInfo: UserInfo) = {
    f.value.getOrElse(Nil).map(v =>
      Tables.DataRow(
        0L,
        f.uuid.get,
        ownerUuid,
        v.uuid.getOrElse(UUID.randomUUID().toString),
        subreferenceUuid,
        v.value.map(_.toString),
        userInfo.uuid,
        DateUtils.ts,
      )
    )
  }
}
