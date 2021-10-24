package be.frol.chaman


import java.io.File
import java.nio.file
import java.nio.file.FileSystems
import scala.reflect.io.Path

object Conf {
  def thumbnail(uuid: String): File =
    FileSystems.getDefault.getPath(Conf.fileStoragePath.path,"thumbnails", uuid + ".jpg").toFile

  def annex(sha1Sum: String): File =
    FileSystems.getDefault.getPath(Conf.fileStoragePath.path, "annexes", sha1Sum).toFile

  val frontRootUrl = "/"

  val qrCodePrefix = "http://chaman.frol.be/item/"

  val openIdUrl = "http://keycloak:8080/auth/realms/master/"
  val client_id = "chaman"

  val thumbnailWidth = 200

  val fileStoragePath = Path("/data/")


  val redisHost = "redis"
}
