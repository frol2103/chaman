package be.frol.chaman.api

import be.frol.chaman.Conf
import be.frol.chaman.service.ItemService
import be.frol.chaman.utils.{PdfUtils, QrUtils}
import play.api.db.slick.DatabaseConfigProvider
import play.api.mvc._
import slick.dbio.DBIO

import java.util.Base64
import javax.inject.Inject
import scala.concurrent.ExecutionContext

class Media @Inject()(
                       c: ControllerComponents,
                       val itemService: ItemService,
                     )(
                       implicit val ec: ExecutionContext,
                       val dbConfigProvider: DatabaseConfigProvider,
                     ) extends AbstractController(c) with DbContext {

  def itemQr(id: String) = Action { r =>
    Ok(qrCode(id)).as("image/png");
  }

  private def qrCode(id: String) = {
    val stream = QrUtils.qrCodeOS(Conf.qrCodePrefix + id)
    val r = stream.toByteArray
    stream.close()
    r
  }

  def sticker(id: String) = Action.async { r =>
    db.run(
      stickerHtmlString(id, r.getQueryString("width").map(_.toFloat), r.getQueryString("height").map(_.toFloat))
        .map(v => Ok(PdfUtils.toPdfBytes(v)).as("application/pdf"))
    )
  }

  private def stickerHtmlString(id: String, width:Option[Float], height:Option[Float]) : DBIO[String]= {
    itemService.get(id).map(i => views.html.Sticker.apply(
      Base64.getEncoder().encodeToString(qrCode(id)),
      i.title,
      i.description,
      width.getOrElse(100),
      height.getOrElse(50),
    ).toString)
  }

  def debug() = Action { request =>
    Ok(request.headers.toMap.mkString("\n"))


  }
}
