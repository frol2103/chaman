package be.frol.chaman

import java.nio.file
import java.nio.file.FileSystems
import scala.reflect.io.Path

object Conf {
  def annexPath(sha1Sum: String): file.Path =
    FileSystems.getDefault.getPath(Conf.annexStoragePath.path, sha1Sum)

  val frontRootUrl = "/"

  val qrCodePrefix = "http://chaman.frol.be/item/"

  val openIdUrl = "http://keycloak:8080/auth/realms/master/"
  val client_id = "chaman"

  val annexStoragePath = Path("/annexes/")
}
