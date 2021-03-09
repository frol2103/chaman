package be.frol.chaman.api

import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

trait DbContext extends HasDatabaseConfigProvider[JdbcProfile]{

  protected val dbConfigProvider: DatabaseConfigProvider
  protected lazy val api = dbConfig.profile.api
}
