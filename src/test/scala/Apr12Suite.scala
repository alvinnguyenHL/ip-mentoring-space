import Apr12.{Printable, format}
import Apr5MyFunctor.{Branch, Leaf, Tree}
import cats.implicits._
import minitest._


object Apr12Suite extends SimpleTestSuite {
  
  test("test") {
    
    implicit val print: Printable[Int] = new Printable[Int] {
      def format(x: Int): String = x.toString
    }
    
    val test = format[Int](2)
    assertEquals(test, "2")
  }
  
  test("test2") {
    
  }
  
}
