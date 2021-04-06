package be.frol.chaman.mapper

import be.frol.chaman.model.RichField
import be.frol.chaman.openapi.model.Template
import be.frol.chaman.tables.Tables
import be.frol.chaman.utils.DateUtils
import be.frol.chaman.utils.OptionUtils._
import play.api.libs.json.{JsObject, Json}

import java.util.UUID

object TemplateMapper {


  def toDto(f:Tables.TemplateRow, fields:Option[Seq[RichField]]=None) : Template = {
    Template(
      f.uuid.toOpt,
      List().toOpt(),
      f.label.toOpt,
      f.reference.toOpt,
      fields.map(_.map(FieldMapper.toDto(_)).toList)
    )
  }

  def toRow(f:Template) = {
    Tables.TemplateRow(
      0L,
      f.uuid.map(_.toString).getOrElse(UUID.randomUUID().toString),
      f.reference.getOrThrow("missing reference"),
      f.label.getOrElse(""),
      DateUtils.ts,
    )

  }
}
