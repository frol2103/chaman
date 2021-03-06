package be.frol.chaman.mapper

object TraversableUtils {

  implicit def traversableToRichTraversable[T](t: Traversable[T]) = new AnyRef{
    def toMapBy[K](f: T=>K) = t.map(v => f(v) -> v).toMap
    def maxByOption[B](f:T=>B)(implicit cmp: Ordering[B]) = if(t.isEmpty) None else Some(t.maxBy(f))
    def minByOption[B](f:T=>B)(implicit cmp: Ordering[B]) = if(t.isEmpty) None else Some(t.minBy(f))
  }
}
