package be.frol.chaman.mapper

import be.frol.chaman.model.RichForm
import be.frol.chaman.openapi.model.Template
import be.frol.chaman.tables.Tables
import be.frol.chaman.tables.Tables._
import be.frol.chaman.utils.DateUtils
import be.frol.chaman.utils.OptionUtils._

import java.util.UUID

object TemplateMapper {


  def toDto(f: RichForm, details: Boolean = true): Template = {
    Template(
      f.uuid.toOpt,
      if (details) f.parents.map(toDto(_, details=false)).toList.toOpt() else None,
      f.title.toOpt,
      f.reference.toOpt,
      if (details) f.fields.values.map(FieldMapper.toDto(_)).toList.toOpt else None,
    )
  }

  def toDto(f: TemplateRow): Template = {
    Template(
      f.uuid.toOpt,
      None,
      f.label.toOpt,
      f.reference.toOpt,
      None,
    )
  }

  def toRow(f: Template) = {
    Tables.TemplateRow(
      0L,
      f.uuid.map(_.toString).getOrElse(UUID.randomUUID().toString),
      f.reference.getOrThrowM("missing reference"),
      f.label.getOrElse(""),
      DateUtils.ts,
    )

  }
}
