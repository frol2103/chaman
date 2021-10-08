package be.frol.chaman.api

import be.frol.chaman.error.AuthentificationError
import be.frol.chaman.utils.OptionUtils.enrichedOption
import play.api.mvc.Request

trait ParentController {
  case class UserInfo(uuid: String)

  def run[T](f: UserInfo => T)(implicit request: Request[_]) = f{
    UserInfo(request.session.get("user").getOrThrow(new AuthentificationError()))
  }

}
