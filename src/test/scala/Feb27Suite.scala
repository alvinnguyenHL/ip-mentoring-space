package notes

import minitest._

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext}

object Feb27Suite extends SimpleTestSuite {
  import Feb27TypeClass._
  import scala.concurrent.ExecutionContext.Implicits.global
  
  test("should be") {
    assertEquals(2, 1 + 1)
  }
  
  test("add should sum") {
    assertEquals(6, add(1,5))
  }
  
  test("map test") {
    val result = List(2,3,4)
    assertEquals(result, xs)
  }
  
  testAsync("future map test") {
    val f2 = future2future(b)
    for(r <- f2) yield (r)
    
    
    val f = future2future(a)
    for (r <- f) yield (assertEquals(r, "2 From the future"))
    //assertEquals("2 From the future", f)
    
  }
  
  test("future test") {
    val f2 = future2future(b)
    
    val result = f2.foreach(println)//Await.result(f2,Duration(1,"second"))
    
    assert(1 ==1)
  }
  
}
