package be.frol.chaman.api

import akka.actor.ActorSystem
import akka.stream.Materializer
import be.frol.chaman.Conf
import be.frol.chaman.openapi.api.EventApi
import be.frol.chaman.openapi.model.Event
import be.frol.chaman.utils.OptionUtils.enrichedOption
import play.api.Logging
import play.api.db.slick.DatabaseConfigProvider
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, AnyContent, ControllerComponents, Request}
import redis.RedisClient

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class EventApiImpl @Inject()(
                              val cc: ControllerComponents,
                              val dbConfigProvider: DatabaseConfigProvider,
                            )(implicit executionContext: ExecutionContext, system: ActorSystem, mat: Materializer)
  extends AbstractController(cc) with EventApi with ParentController with DbContext with Logging{

  val redisClient = RedisClient(Conf.redisHost)

  override def addEvent(event: Option[Event])(implicit request: Request[AnyContent]): Future[Unit] = run { implicit user =>
    val eventStr = Json.toJson(event.getOrThrowM("event is mandatory")).toString()
    redisClient.publish(user.uuid, eventStr)
      .map(v => Ok(v + ""))
  }

}
