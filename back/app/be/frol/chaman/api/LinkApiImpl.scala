package be.frol.chaman.api

import akka.actor.ActorSystem
import akka.stream.Materializer
import be.frol.chaman.mapper.LinkMapper
import be.frol.chaman.openapi.api.LinkApi
import be.frol.chaman.openapi.model.Link
import be.frol.chaman.service.{ItemService, LinkService}
import be.frol.chaman.tables.Tables.LinkRemovedRow
import be.frol.chaman.utils.DateUtils
import play.api.Logging
import play.api.db.slick.DatabaseConfigProvider
import play.api.mvc.{AbstractController, AnyContent, ControllerComponents, Request}

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class LinkApiImpl @Inject()(
                             val cc: ControllerComponents,
                             val linkService: LinkService,
                             val itemService: ItemService,
                             val dbConfigProvider: DatabaseConfigProvider,
                           )(implicit executionContext: ExecutionContext, system: ActorSystem, mat: Materializer)
  extends AbstractController(cc) with LinkApi with ParentController with DbContext with Logging {

  override def addLink(uuid: String, linkedUuid: String)(implicit request: Request[AnyContent]): Future[Link] = run { implicit user =>
    db.run(
      for {
        l <- this.linkService.add(LinkMapper.toRow(uuid, linkedUuid))
        i <- this.itemService.get(linkedUuid)
      } yield LinkMapper.toDto(l, i)
    )
  }

  override def deleteLink(uuid: String)(implicit request: Request[AnyContent]): Future[Unit] = run { implicit user =>
    db.run(
      this.linkService.get(uuid).flatMap(l =>
        this.linkService.delete(new LinkRemovedRow(l.id,user.uuid, DateUtils.ts))
      )
    ).map(_ => None)
  }
}
