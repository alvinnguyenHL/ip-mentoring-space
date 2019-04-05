package notes

import minitest._

object Mar8MyFunctorSuite extends SimpleTestSuite {
  import Mar8MyFunctor._
  
  test("person equal") {
    val x: Person = Person(28, "Alvin Nguyen")
    val y: Person = Person(5, "Bob")
    val x2: Person = Person(28, "Alvin Nguyen")

    assertEquals(personEqual.equal(x,y), false)
    assertEquals(personEqual.equal(x,x2), true)
  }
  
  test("implicit test") {
    import Mar8MyFunctor._
    val x: Person = Person(28, "Alvin Nguyen")
    val y: Person = Person(5, "Bob")
    val z: Person = Person(10, "John")
    val x2: Person = Person(28, "Alvin Nguyen")

    //assertEquals(Equal[Person].equal(x,y), false)
    assert(Equal[Int].equal(1,1))
  }
  
}
