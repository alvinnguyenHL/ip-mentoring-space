import Apr19._
import minitest._

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global


object Apr19Suite extends SimpleTestSuite {
  
  test("test") {
    assertEquals(x(), 24)
  }
  
  test("test eval2") {
    assertEquals(eval2(program), 12)
  }

  test("test evalString") {
    assertEquals(evalString(program), "((1 add 2) mul 4)")
  }
  
  testAsync("test Futures") {
    eval3(program).map(assertEquals(_,12))
  }
  
}
