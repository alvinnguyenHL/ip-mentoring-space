import Apr5MyFunctor.{Branch, Leaf, Tree}
import minitest._
import cats._
import cats.implicits._


object Apr5MyFunctorSuite extends SimpleTestSuite {
  
  test("test tree") {
    val testTree: Tree[Int] = Branch(Leaf(1), Leaf(2))
    assertEquals(testTree, Branch(Leaf(1), Leaf(2)))
  }
  
  test("test tree functor") {
    val testTree: Tree[Int] = Branch(Leaf(1), Leaf(2))
    def addOne(x: Int): Int = x + 1
    val sumh: (Int, Int) => Int = _ + _
    
    val result = testTree map {
      addOne  
    }

    assertEquals(result, Branch(Leaf(2), Leaf(3)))
    
    assertEquals(sumh(2,4), 6)
  }
  
}
