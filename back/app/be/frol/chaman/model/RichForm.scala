package be.frol.chaman.model
import be.frol.chaman.mapper.TraversableUtils.traversableToRichTraversable
import be.frol.chaman.tables.Tables._
import be.frol.chaman.utils
import play.api.Logging
case class RichForm(uuid: String,reference:String,title:String, fields: Map[String, RichField], parents: Seq[RichForm]) {
}

object RichForm extends Logging{
  def build(uuid:String, parentGraph: ParentGraph, fields:Map[String, Seq[RichField]], templates:Map[String, TemplateRow]): RichForm ={
    if(parentGraph.parentsFor(uuid).isEmpty) {
      RichForm(uuid,templates(uuid).reference, templates(uuid).label, fields.get(uuid).getOrElse(Nil).toMapBy(_.fieldUuid), Nil)
    } else {
      val parentForms : Seq[RichForm] = parentGraph.parentsFor(uuid).map( build(_,parentGraph, fields, templates))
      RichForm(
        uuid,
        templates(uuid).reference,
        templates(uuid).label,
        {
          val parentFields = parentForms.map(_.fields).reduce(_ ++ _)
          logger.error("cuild rich form " + uuid + " parent fields " + parentFields.keySet)
          logger.error("cuild rich form " + uuid + " fields with value " + fields.get(uuid).getOrElse(Nil).map(f => f.fieldUuid + ":" + f.fieldData.map(_.value)))
          val overridenFieldsWithParentFieldsInfos = fields.get(uuid).getOrElse(Nil)
            .map(f => f.copy(parents = parentForms.flatMap(p => p.fields.get(f.fieldUuid)))).toMapBy(_.fieldUuid)
          parentFields ++
            overridenFieldsWithParentFieldsInfos
        },
        parentForms)
    }
  }
}

