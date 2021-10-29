package be.frol.chaman.api

import be.frol.chaman.error.AuthentificationError
import be.frol.chaman.model.UserInfo
import be.frol.chaman.utils.OptionUtils.enrichedOption
import play.api.Logging
import play.api.mvc.{Request, RequestHeader}

trait ParentController extends Logging{

  def run[T](f: UserInfo => T)(implicit request: RequestHeader) = f{
    UserInfo(request.session.get("user").getOrThrow(new AuthentificationError()))
  }

}


