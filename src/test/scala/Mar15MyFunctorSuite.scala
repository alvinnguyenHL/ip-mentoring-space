package notes

import minitest._
import Mar15MyFunctor._

import scala.concurrent.Future
import scala.util.{Failure, Success}

object Mar15MyFunctorSuite extends SimpleTestSuite {
  
  test("map add one") {
    val xs: List[Int] = List(1,2,3,4)
    val expected: List[Int] = List(2,3,4,5)
    
    assertEquals(xs.map(addOne), expected)
    
  }

  test("map map map") {
    val xs2: List[Int] = List(0,0,0,0)
    val expected2: List[String] = List("1 Im a String","1 Im a String","1 Im a String","1 Im a String")
    
    assertEquals(xs2.map(addOne).map(square).map(intToString), expected2)
  }

  testAsync("map good future") {
    import scala.concurrent.ExecutionContext.Implicits.global
    
    val future = goodFuture

    
    myFuture(future).map(assertEquals(_,"4 Im a String"))
    
    /*
    for(inside <- myFuture(goodFuture)) yield {
      assertEquals(inside,"4 Im a String")
    }
    */
  }

  test("map bad future") {
    import scala.concurrent.ExecutionContext.Implicits.global

    val future = badFuture

    myFuture(future).onComplete{
      case Failure(_) => true
      case Success(_) => fail()
    }

  }

  testAsync("map bad future 2") {
    import scala.concurrent.ExecutionContext.Implicits.global
    
    val isFailedFuture: Future[Boolean] = badFuture transformWith(t => Future(t.isFailure))
    isFailedFuture.map(assert(_))
  }
  
}
