import cats._
import cats.implicits._

object Apr5MyFunctor {

  sealed trait Tree[T]
  final case class Branch[T](left: Tree[T], right: Tree[T]) extends Tree[T]
  final case class Leaf[T](value: T) extends Tree[T]
  
  implicit val myTreeFuctor: Functor[Tree] = new Functor[Tree] {
    def map[A, B](fa: Tree[A])(f: A => B): Tree[B] = fa match {
      case Branch(left, right) => Branch(map(left)(f), map(right)(f))
      case Leaf(value) => Leaf(f(value))
    }
  }

  val plusOne: Int => Int = _ + 1
  val plusOneb = (a: Int) => a +1

  def foo(g: (Int) => Int) = g(2)

  def sum(x: Int, y: Int): Int = x + y
  val sumf: (Int,Int) => Int = (x,y) => x + y
  val sumg = (x: Int, y: Int) => x + y


  
  /*
    def apply[T](body: ⇒ T)(implicit executor: ExecutionContext): Future[T]
   */
  
  /*
  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  // Example implementation for Option
  implicit val functorForOption: Functor[Option] = new Functor[Option] {
    def map[A, B](fa: Option[A])(f: A => B): Option[B] = fa match {
      case None    => None
      case Some(a) => Some(f(a))
    }
  }
  */
  
  
  
}
