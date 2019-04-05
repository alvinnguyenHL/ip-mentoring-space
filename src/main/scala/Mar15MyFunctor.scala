package notes

import scala.concurrent.Future

object Mar15MyFunctor {
  import scala.concurrent.ExecutionContext.Implicits.global
  
  val addOne: (Int) => Int = x => {
    //println(s"$x in addOne")
    x + 1
  }
  val square: (Int) => Int = x => {
    //println(s"$x in square")
    x * x
  }
  val intToString: (Int) => String = x => x + " Im a String"
  
  val goodFuture: Future[Int] = Future(1)
  
  val badFuture: Future[Int] = Future("bad".toInt)
  
  val myFuture: (Future[Int]) => Future[String] = 
    _.map(addOne).map(square).map(intToString)
  
}
