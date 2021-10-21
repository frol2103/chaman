package be.frol.chaman.utils

import scala.util.{Failure, Success, Try}

object TryUtils {

  implicit def tryEnriched[T](t : Try[T]) = new AnyRef{
    def mapError(f:Throwable=>Throwable):Try[T] = {
      t.transform(s=>Try{s}, v=>Failure(f(v)))
    }
    def mapError(f: =>Throwable):Try[T] = {
      t.transform(s=>Try{s}, v=>Failure(f))
    }

    def getOrThrowM(m: => String) = t match {
      case Success(v) => v
      case Failure(f) => throw new RuntimeException(m, f)
    }
  }

}
