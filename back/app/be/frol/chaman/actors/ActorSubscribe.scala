package be.frol.chaman.actors

import java.net.InetSocketAddress

import akka.actor.{ActorRef, PoisonPill}
import redis.RedisClient
import redis.actors.RedisSubscriberActor
import redis.api.pubsub.{Message, PMessage}

class SubscribeActor(redis: RedisClient,
                     out: ActorRef,
                     channels: Seq[String] = Nil,
                     patterns: Seq[String] = Nil)
  extends RedisSubscriberActor(
    new InetSocketAddress(redis.host, redis.port), channels, patterns,
    onConnectStatus = connected => {}) {

  def onMessage(message: Message) {
    out ! message.data.decodeString("UTF-8")
  }

  override def onPMessage(pm: PMessage): Unit = {}
}
