package notes

import cats._
import cats.instances.function._
import cats.syntax.functor._

object Mar22MyFunctor {
  
  //def intToDouble(x: Int): Double = x.toDouble
  val intToDouble: Int => Double = (x: Int) => x.toDouble
  
  //def doubleToString(x: Double): String = x.toString
  val doubleToString: Double => String = (x: Double) => x.toString
  
  val f: Int => Double = (x: Int) => x.toDouble * 1.1
  val g: Double => Double = (y: Double) => y *100
  
  val answer: String = doubleToString(intToDouble(2))
  
  val answer3: Double = (f map g)(3)
  
  val answer2: String = (intToDouble map doubleToString)(1)
  
  /*
  trait Funtion1[A, B] {
    def apply(arg: A):B
     }
     
  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(func: A => B): F[B]
  }
 */
  
  type F[A] = Int => A
  
}
