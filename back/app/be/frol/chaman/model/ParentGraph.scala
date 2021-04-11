package be.frol.chaman.model

import be.frol.chaman.error.ParentCycleError
import be.frol.chaman.tables.Tables._
import play.api.Logging

class ParentGraph(linksByChildren: Map[String, Seq[TemplateParentRow]] = Map(), val childrenCovered: Set[String] = Set()) extends Logging {

  def assertNoCycles(baseUuid: String, parents:List[String]): Unit = {
    def checkNoCycleFor(uuid: String): Unit = {
      (if(uuid == baseUuid) parents else parentsFor(uuid)).foreach(v => {
        if (v == baseUuid) throw new ParentCycleError("Parent graph cannot have cycles")
        else checkNoCycleFor(v)
      })
    }

    checkNoCycleFor(baseUuid)
  }

  def missingFor(uuids: Seq[String]) = {
    def missingFor(uuid: String): Seq[String] = {
      if (childrenCovered.contains(uuid)) parentsFor(uuid).flatMap(missingFor(_))
      else List(uuid)
    }
    uuids.flatMap(missingFor(_))
  }

  def parentsFor(uuid: String): Seq[String] = {
    parentsRowsFor(uuid).map(_.parentReference)
  }

  def parentsRowsFor(uuid: String): Seq[TemplateParentRow] = {
    if (!childrenCovered.contains(uuid)) throw new RuntimeException("Error in hierarchy")
    else linksByChildren.get(uuid).getOrElse(Nil)
  }

  def desc: String = linksByChildren.map { case (k, v) => k + ":" + v.map(l => "c(" + l.childReference + ")->p(" + l.parentReference + ")").mkString(" , ") }.mkString("\n")

  def addLinksFor(childrens: Set[String], rows: Seq[TemplateParentRow]) = new ParentGraph(linksByChildren ++ rows.groupBy(_.childReference), childrenCovered ++ childrens)
}

object ParentGraph {
  def apply(childrens: Set[String], rows: List[TemplateParentRow]) = new ParentGraph(rows.groupBy(_.childReference), childrens)
}
