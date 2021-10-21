package be.frol.chaman.api

import be.frol.chaman.{Conf, tables}
import be.frol.chaman.mapper.AnnexMapper
import be.frol.chaman.openapi.api.AnnexApi
import be.frol.chaman.openapi.model.Annex
import be.frol.chaman.service.AnnexService
import be.frol.chaman.tables.Tables
import be.frol.chaman.tables.Tables.AnnexRow
import be.frol.chaman.utils.DateUtils
import be.frol.chaman.utils.OptionUtils.{enrichedObject, enrichedOption}
import play.api.db.slick.DatabaseConfigProvider
import play.api.libs.Files
import play.api.mvc.{AnyContent, ControllerComponents, Request}

import java.nio.file.{FileSystem, FileSystems}
import java.util.UUID
import javax.inject.Inject
import javax.xml.bind.DatatypeConverter
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.reflect.io.Path

class AnnexApiImpl @Inject()(
                              val cc: ControllerComponents,
                              val annexService: AnnexService,
                              val dbConfigProvider: DatabaseConfigProvider,
                            ) extends AnnexApi with ParentController with DbContext {
  override def uploadFile(uuid: String, file: Option[Files.TemporaryFile])(implicit request: Request[AnyContent]): Future[Annex] = run { implicit u =>
    request.body.asMultipartFormData.flatMap(_.file("file")).map{f =>
      val sha1Sum = DatatypeConverter.printHexBinary(
        java.security.MessageDigest.getInstance("SHA-1").digest(
          java.nio.file.Files.readAllBytes(file.get.path)))

      java.nio.file.Files.move(file.get.path, Conf.annex(sha1Sum).toPath)
      db.run(
        annexService.add(AnnexRow(0L, UUID.randomUUID().toString, uuid, sha1Sum, f.filename,
        f.contentType.getOrThrowM("mime type missing"),u.uuid,DateUtils.ts))
      ).map(AnnexMapper.toDto(_))
    }.getOrElse(throw new RuntimeException("missing file"))

  }

  override def deleteAnnex(uuid: String)(implicit request: Request[AnyContent]): Future[Unit] = run { implicit user =>
    db.run(
      annexService.find(uuid).flatMap(a =>
        annexService.delete(new tables.Tables.AnnexRemovedRow(a.id, user.uuid, DateUtils.ts))
          .map(_ => None)
      )
    )
  }
}
