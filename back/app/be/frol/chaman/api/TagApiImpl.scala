package be.frol.chaman.api

import akka.actor.ActorSystem
import akka.stream.Materializer
import be.frol.chaman.Conf
import be.frol.chaman.openapi.api.{EventApi, TagApi}
import be.frol.chaman.openapi.model.Event
import be.frol.chaman.service.TagService
import be.frol.chaman.tables.Tables.FieldTagRow
import be.frol.chaman.utils.DateUtils
import be.frol.chaman.utils.OptionUtils.enrichedOption
import play.api.Logging
import play.api.db.slick.DatabaseConfigProvider
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, AnyContent, ControllerComponents, Request}
import redis.RedisClient

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class TagApiImpl @Inject()(
                              val cc: ControllerComponents,
                              val dbConfigProvider: DatabaseConfigProvider,
                              val tagService: TagService,
                            )(implicit executionContext: ExecutionContext, system: ActorSystem, mat: Materializer)
  extends AbstractController(cc) with TagApi with ParentController with DbContext with Logging{

  override def addTag(uuid: String, value: String)(implicit request: Request[AnyContent]): Future[Unit] = run{ user =>
    db.run(
      tagService.add(new FieldTagRow(0L, uuid, value,user.uuid, DateUtils.ts))
    ).map(_ => None)
  }

  override def getAllTags(uuid: String)(implicit request: Request[AnyContent]): Future[List[String]] = {
    db.run(
      tagService.find(uuid).map(_.map(_.value).toList)
    )
  }
}
