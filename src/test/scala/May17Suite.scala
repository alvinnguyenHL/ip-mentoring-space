import May17.{Interp, run}
import minitest._

object May17Suite extends SimpleTestSuite {
  
  test("should be") {
    assertEquals(run(Interp), true)
  }
  
  
}
