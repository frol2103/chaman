package be.frol.chaman.service

import be.frol.chaman.api.{DbContext, OpenConnectId}
import be.frol.chaman.tables.Tables
import be.frol.chaman.tables.Tables.UserRow
import be.frol.chaman.utils.DateUtils
import play.api.db.slick.DatabaseConfigProvider

import java.util.UUID
import javax.inject.Inject
import scala.concurrent.ExecutionContext

  class UserService @Inject()(
                               val dbConfigProvider: DatabaseConfigProvider,
                             ) extends DbContext {


    import api._

    def add(p: Tables.UserRow) = {
      ((Tables.User returning Tables.User.map(_.id)
        into ((v, id) => v.copy(id = id))) += p)
    }

    def user(id : OpenConnectId)(implicit excecutionContext: ExecutionContext) = {
      get(id).flatMap{
        case Some(s) => DBIO.successful(s)
        case None => create(id)
      }
    }

    def get(id: OpenConnectId)(implicit executionContext: ExecutionContext) : DBIO[Option[UserRow]]= {
      Tables.User
        .filter(_.openidconnectiss === id.iss)
        .filter(_.openidconnectsub === id.sub)
        .result.headOption
    }

    def create(id: OpenConnectId) = {
      add(Tables.UserRow(0L,UUID.randomUUID().toString, id.username,id.iss, id.sub, DateUtils.ts))
    }
  }
