package be.frol.chaman.api

import akka.actor.{ActorRef, ActorSystem, Props}
import akka.stream.Materializer
import be.frol.chaman.Conf
import be.frol.chaman.actors.SubscribeActor
import play.api.Logging
import play.api.libs.streams.ActorFlow
import play.api.mvc.{AbstractController, ControllerComponents, WebSocket}
import redis.RedisClient

import javax.inject.Inject
import scala.concurrent.ExecutionContext


class Websocket @Inject()(cc: ControllerComponents)
                         (implicit executionContext: ExecutionContext, system: ActorSystem, mat: Materializer)
  extends AbstractController(cc) with ParentController with Logging {

  val redisClient = RedisClient(Conf.redisHost)

  def userEvents() = WebSocket.accept[String, String] { implicit request =>
    run { implicit user =>
      def props(channel: String)(out: ActorRef) = Props(classOf[SubscribeActor], redisClient,
        out, Seq(channel), Nil)
      ActorFlow.actorRef { out =>
        props(user.uuid)(out)
      }
    }
  }

}
