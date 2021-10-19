package be.frol.chaman

import scala.reflect.io.Path

object Conf {
  val frontRootUrl = "/"

  val qrCodePrefix = "http://chaman.frol.be/item/"

  val openIdUrl = "http://keycloak:8080/auth/realms/master/"
  val client_id = "chaman"

  val annexStoragePath = Path("/annexes/")
}
