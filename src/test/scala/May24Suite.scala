
import May24._
import minitest._

object May24Suite extends SimpleTestSuite {

  test("should be Some") {
    assertEquals(stringDivision("2", "2"), Some(1))
  }

  test("should be None") {
    assertEquals(stringDivision("2", "asdf"), None)
  }

  test("should be a failure") {
    assertEquals(Try("3".toInt), Success(3))
    
  }
  
  test("should be a failure") {
    assertEquals(Try("asdf".toInt), Failure(new NumberFormatException("For input string: \"asdf\"")))
  }
  
}
