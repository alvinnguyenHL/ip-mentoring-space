import Apr19._
import minitest._


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
  
}
