package be.frol.chaman.error

class AuthentificationError(s:String = "Not authenticated", e:Exception=null) extends RuntimeException(s,e){

}
