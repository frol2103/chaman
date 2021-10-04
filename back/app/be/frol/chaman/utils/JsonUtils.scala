package be.frol.chaman.utils

import play.api.libs.json.{JsError, JsResult, JsSuccess}

object JsonUtils {
  implicit def richJsResult[T](v: JsResult[T]) = new AnyRef{
    def getOrThrow() = v match {
      case JsSuccess(value, path) => value
      case JsError(errors) => throw new RuntimeException("error while parsing " + errors)
    }
  }

}
