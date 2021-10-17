package be.frol.chaman.utils

import play.api.libs.json.{JsError, JsResult, JsSuccess, JsValue}

object JsonUtils {
  implicit def richJsResult[T](v: JsResult[T]) = new AnyRef{
    def getOrThrow(originalMessage : Option[JsValue] = None) = v match {
      case JsSuccess(value, path) => value
      case JsError(errors) => throw new RuntimeException("error while reading json -" + originalMessage + "- : " + errors)
    }
  }

}
