package be.frol.chaman.openid

import pdi.jwt.{JwtJson, JwtOptions}
import play.api.libs.json.{JsError, JsObject, JsResult, JsSuccess, Json}
import play.api.libs.ws.{WSClient, WSResponse}

import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class OpenIdConnectClient @Inject()(ws: WSClient)(implicit executionContext: ExecutionContext) {

  def redirectURL(openIdClient: OpenIdConnectConfig, redirectUrl: String): Future[String] = {
    discover(openIdClient).map { serverInfos =>
      url(serverInfos.authorization_endpoint,
        "client_id" -> openIdClient.clientId,
        "redirect_uri" -> redirectUrl,
        "scope" -> openIdClient.scope,
        "response_type" -> "code",
      )
    }
  }

  def getToken(openIdClient: OpenIdConnectConfig, redirectUrl: String, code: String) = {
    discover(openIdClient).flatMap { serverInfos =>
      ws.url(serverInfos.token_endpoint)
        .post(Map(
          "grant_type" -> Seq("authorization_code"),
          "client_id" -> Seq(openIdClient.clientId),
          "redirect_uri" -> Seq(redirectUrl),
          "code" -> Seq(code)
        )).flatMap {
        case r if r.status >= 200 && r.status < 300 => parseTokenResponse(r)
        case r => Future.failed(new OpenIdConnectException("Error(" + r.status + ") when getting token " + r.body))
      }
    }

  }

  private def parseTokenResponse(r: WSResponse) = {
    val token: Future[String] = Future((Json.parse(r.body) \ "access_token").validate[String] match {
      case JsSuccess(s, _) => s
      case e => throw new OpenIdConnectException("cannot read response from token request " + e)
    })
    token.flatMap(t => Future.fromTry(JwtJson.decodeJson(t, JwtOptions.DEFAULT.copy(signature = false)))
      .recoverWith { case f => Future.failed[JsObject](new OpenIdConnectException("Failed to parse jwt token", f)) })
  }

  def discover(openIdClient: OpenIdConnectConfig) = {
    ws.url(openIdClient.discoveryUrl)
      .get()
      .map(r => r.json.validate[OpenIdConnectServerInfo](OpenIdConnectServerInfo.format))
      .map {
        case JsSuccess(value, _) => value
        case JsError(errors) => throw new OpenIdConnectException(
          "Error while parsing response from the the discovery at url :" + openIdClient.discoveryUrl + " : " + errors)
      }
  }


  def url(base: String, queryParams: (String, String)*) = base + "?" +
    queryParams.map(v => v._1 + "=" + URLEncoder.encode(v._2, StandardCharsets.UTF_8.toString)).mkString("&")

}


case class OpenIdConnectServerInfo(
                                    authorization_endpoint: String,
                                    token_endpoint: String,
                                  )

case class OpenIdConnectConfig(
                                baseUrl: String,
                                clientId: String,
                                scope: String = "openid profile"
                              ) {

  lazy val discoveryUrl = baseUrl + ".well-known/openid-configuration"
}

object OpenIdConnectServerInfo {
  implicit val format = Json.format[OpenIdConnectServerInfo]
}
