package be.frol.chaman.utils

object OptionUtils {

  implicit def enrichedOption[T](o: Option[T]) = new AnyRef{
    def getOrThrow(e: =>Exception) : T= o.getOrElse(throw  e)
    def getOrThrow(e: String) : T= o.getOrElse(throw  new RuntimeException(e))
  }

  implicit def enrichedObject[T](t:T) = new AnyRef{
    def toOpt() = Option(t)
  }

}
