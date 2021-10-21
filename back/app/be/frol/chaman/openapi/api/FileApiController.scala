package be.frol.chaman.openapi.api

import be.frol.chaman.Conf
import be.frol.chaman.api.DbContext
import be.frol.chaman.service.AnnexService
import play.api.db.slick.DatabaseConfigProvider
import play.api.mvc._

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class FileApiController @Inject()(
                                                    val cc: ControllerComponents,
                                                    val annexService: AnnexService,
                                                    val dbConfigProvider: DatabaseConfigProvider,
                                                  )(implicit executionContext: ExecutionContext)
  extends AbstractController(cc) with DbContext {
  /**
   * GET /api/annex/:uuid/file
   */
  def getAnnexFile(uuid: String): Action[AnyContent] = Action.async { request =>
    db.run(
      annexService.find(uuid)
        .map(a =>
          Ok(java.nio.file.Files.readAllBytes(Conf.annex(a.filesha).toPath))
            .as(a.mimetype)
            .withHeaders("Content-Disposition" -> ("attachment; filename=\"" + a.name + "\""))
        )
    )
  }


  def getThumbnailFile(uuid: String) = Action{request =>
    Ok(java.nio.file.Files.readAllBytes(Conf.thumbnail(uuid).toPath))
      .as("image/jpg")
  }

}
