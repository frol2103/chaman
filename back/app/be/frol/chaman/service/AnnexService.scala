package be.frol.chaman.service

import be.frol.chaman.api.DbContext
import be.frol.chaman.model.{RichField, UserInfo}
import be.frol.chaman.tables.Tables
import be.frol.chaman.tables.Tables.{DataDeletedRow, DataRow}
import be.frol.chaman.utils.DateUtils
import be.frol.chaman.utils.TraversableUtils.traversableEnriched
import play.api.db.slick.DatabaseConfigProvider
import slick.util.Logging

import javax.inject.Inject
import scala.concurrent.ExecutionContext

class AnnexService @Inject()(
                                  val dbConfigProvider: DatabaseConfigProvider,
                                  val fieldService: FieldService,
                                ) extends DbContext with Logging {


  import api._

  def add(p: Tables.AnnexRow) = {
    ((Tables.Annex returning Tables.Annex.map(_.id)
      into ((v, id) => v.copy(id = id))) += p)
  }

  def delete(p: Tables.AnnexRemovedRow) = {
    Tables.AnnexRemoved += p
  }


  def forItem(uuid:String) = lastVersion.filter(_.itemUuid === uuid).result

  def find(uuid: String) = lastVersion.filter(_.uuid === uuid).result.head

  val lastVersion = {
    Tables.Annex.filterNot(f => Tables.Annex.filter(_.uuid === f.uuid)
      .filter(_.id > f.id).exists)
      .filterNot(f => Tables.AnnexRemoved.filter(f.id === _.fkAnnexId).exists)
  }


}
