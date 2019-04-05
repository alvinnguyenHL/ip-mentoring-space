package notes

import scala.concurrent.Future

object Feb27TypeClass {
  import scala.concurrent.ExecutionContext.Implicits.global
  
  def add(x: Int, y: Int): Int = x + y
  
  //F[A]
  //A => B   
  //F[B]
  val xs = List(1,2,3).map {
    x => x +1
  }
  
  //sealed trait Functor[F[_]] ....
  //def map[A, B](fa: F[A])(f: A => B): F[B]
  val f: (Int) => Int = _ +1
  val xs2 = xs.map(_ + 1).map(_ - 2).map(f)
  
  val a: Future[Int] = Future(1)
  val b: Future[Int] = Future("ffff".toInt)
  
  def future2future(future: Future[Int]): Future[String] =
    future.map(f).map(
      _.toString + " From the future"
    )
  
  
  
  
}
