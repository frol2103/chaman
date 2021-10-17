package be.frol.chaman.utils

import play.api.Logging
import play.api.libs.json.{JsError, JsResult, JsSuccess, JsValue}

object JsonUtils extends Logging {
  implicit def richJsResult[T](v: JsResult[T]) = new AnyRef{
    def getOrThrow(originalMessage : Option[JsValue] = None) :T= v match {
      case JsSuccess(value, path) => value
      case JsError(errors) => throw new RuntimeException("error while reading json (" + originalMessage + ") : " + errors)
    }

    def getOrThrowE(e: RuntimeException, originalMessage:Option[JsValue] = None) : T = v match {
      case JsSuccess(value, path) => value
      case JsError(errors) => {
        logger.debug("Error while reading json : " + originalMessage.map("(" + _.toString() + ")").getOrElse("")+ " " + errors)
        throw e
      }
    }
  }

}
