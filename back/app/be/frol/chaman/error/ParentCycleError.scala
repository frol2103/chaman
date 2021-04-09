package be.frol.chaman.error

class ParentCycleError(s:String, e:Exception=null) extends RuntimeException(s,e){

}
