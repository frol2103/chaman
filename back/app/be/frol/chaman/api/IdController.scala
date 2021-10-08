package be.frol.chaman.api

import be.frol.chaman.Conf
import be.frol.chaman.openid.{OpenIdConnectClient, OpenIdConnectConfig}
import be.frol.chaman.service.UserService
import be.frol.chaman.utils.JsonUtils.richJsResult
import be.frol.chaman.utils.OptionUtils.enrichedOption
import play.api.db.slick.DatabaseConfigProvider
import play.api.libs.json.Json
import play.api.mvc._

import javax.inject.Inject
import scala.concurrent.ExecutionContext

class IdController @Inject()(
                              val openIdClient: OpenIdConnectClient,
                              val dbConfigProvider: DatabaseConfigProvider,
                              c: ControllerComponents,
                              userService: UserService,
                            )(
                              implicit val ec: ExecutionContext
                            ) extends AbstractController(c) with DbContext {

  import api._

  lazy val config = OpenIdConnectConfig(Conf.openIdUrl, Conf.client_id)

  def login = Action.async { implicit request =>
    openIdClient
      .redirectURL(config, routes.IdController.openIdCallback.absoluteURL())
      .map(url => Redirect(url))

  }


  def openIdCallback = Action.async { implicit request: Request[AnyContent] =>
    db.run(
      DBIO.from(openIdClient.getToken(config, routes.IdController.openIdCallback.absoluteURL(), request.queryString.get("code").flatMap(_.headOption).getOrThrowM("missing code"))
        .map(_.validate[OpenConnectId](OpenConnectId.format).getOrThrow()))
        .flatMap(userService.user(_))
    ).map(v => Redirect(Conf.frontRootUrl).withSession("user" -> v.uuid))
  }
}

case class OpenConnectId(iss: String, sub: String, preferred_username: String) {
  def username = preferred_username
}

object OpenConnectId {
  implicit val format = Json.format[OpenConnectId]
}
