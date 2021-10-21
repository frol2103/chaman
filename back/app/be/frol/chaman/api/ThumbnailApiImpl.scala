package be.frol.chaman.api

import be.frol.chaman.Conf
import be.frol.chaman.mapper.ThumbnailMapper
import be.frol.chaman.openapi.api.ThumbnailApi
import be.frol.chaman.openapi.model.Thumbnail
import be.frol.chaman.service.{AnnexService, ThumbnailService}
import be.frol.chaman.tables.Tables.ItemThumbnailRow
import be.frol.chaman.utils.DateUtils
import be.frol.chaman.utils.OptionUtils.enrichedOption
import be.frol.chaman.utils.TryUtils.tryEnriched
import org.imgscalr.Scalr
import play.api.db.slick.DatabaseConfigProvider
import play.api.mvc.{AnyContent, ControllerComponents, Request}

import javax.imageio.ImageIO
import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}
import scala.util.Try

class ThumbnailApiImpl @Inject()(
                                  val cc: ControllerComponents,
                                  val dbConfigProvider: DatabaseConfigProvider,
                                  val thumbnailService: ThumbnailService,
                                  val annexService: AnnexService,
                                )(
                                  implicit executionContext: ExecutionContext,
                                ) extends ThumbnailApi with DbContext with ParentController {

  override def setDescription(uuid: String, optIcon: Option[Thumbnail])(implicit request: Request[AnyContent]): Future[Thumbnail] = {

    run { implicit user =>
      val icon = optIcon.getOrThrowM("Icon is mandatory")
      db.run(
        annexService.find(icon.annexUuid.getOrThrowM("annex uuid is mandatory")).flatMap { annex =>
          val image = Try {
            ImageIO.read(Conf.annex(annex.filesha))
          }.getOrThrowM("Couldn't read file associated with annex")
          val width = Math.min(Math.min(icon.width.map(_.toInt).getOrElse(image.getWidth), image.getHeight), image.getWidth)
          val x = Math.min(icon.x.map(_.toInt).getOrElse(Int.MaxValue), (image.getWidth - width) / 2)
          val y = Math.min(icon.y.map(_.toInt).getOrElse(Int.MaxValue), (image.getHeight - width) / 2)
          val croppedImage = image.getSubimage(x, y, width, width)
          val scaledImage = Scalr.resize(croppedImage, Scalr.Method.BALANCED, Conf.thumbnailWidth, Conf.thumbnailWidth)
          ImageIO.write(scaledImage, "jpg", Conf.thumbnail(uuid));
          thumbnailService.add(ItemThumbnailRow(0L, uuid, annex.uuid, x, y, width, user.uuid, DateUtils.ts))
        }
      )
    }.map(ThumbnailMapper.toDto(_))
  }

  override def getDescription(uuid: String)(implicit request: Request[AnyContent]): Future[Thumbnail] = {
    db.run(thumbnailService.find(uuid).map(ThumbnailMapper.toDto(_)))
  }
}
