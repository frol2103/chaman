package be.frol.chaman.utils

object TraversableUtils {

  implicit def traversableEnriched[T](t : TraversableOnce[T]) = new AnyRef{
    def toMapBy[U](f:T=>U) = {
      if(t == null) throw new RuntimeException("t is null")
      t.map((v:T) => f(v) -> v).toMap
    }
  }

}
