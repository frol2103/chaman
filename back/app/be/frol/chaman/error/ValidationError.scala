package be.frol.chaman.error

import play.api.libs.json.JsValue

class ValidationError(val message: String, val content:JsValue) extends RuntimeException(message){

}
