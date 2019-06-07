

object May24 {
  
  //F[A]
  //M[A]
  //Informally Monad = Context with constructor and `flatMap` method.
  //F[A] => F[B], A => F[B] flatMap Monad
  //F[A] => F[B], A => B  map Functor 
  //List, Seq, Option, Either, Future
  
  def divide(a: Int, b: Int): Option[Int] = {
    println(s"Hello $a $b")
    if( b == 0)
      None
    else
      Some(a/b)
  }

  def multiple(a: Int, b: Int): Int =
    a * b
  
 
  def parseInt(a: String): Option[Int] =
    scala.util.Try(a.toInt).toOption
  
  
  def stringDivision(a: String, b: String): Option[Int] =
    parseInt(a).flatMap{ intA =>
      parseInt(b).flatMap { intB =>
        println(s"String Division $intA $intB")
        divide(intA,intB)
      }
    }

  def stringDivision2(a: String, b: String): Option[Int] =
    for {
      intA <- parseInt(a)
      intB <- parseInt(b)
      result <- divide(intA, intB)
    } yield result


  def stringMultiple(a: String, b: String): Option[Int] =
    for {
      intA <- parseInt(a)
      intB <- parseInt(b)
    } yield multiple(intA, intB)


  sealed trait Try[A] {
    def get: A
  }
  
  final case class Success[A](x: A) extends Try[A] {
    val get: A = x
  }
  final case class Failure[A](throwFail: Throwable) extends Try[A] {
    
    lazy val get: A = {
      throw throwFail
    }
      
  }
  
  object Try {
    def apply[A](b: => A): Try[A] = {
      try Success(b) catch {
        case scala.util.control.NonFatal(e) => Failure(e)
      }
    }
  }
  
}
