package notes
import minitest._

object FooSuite extends SimpleTestSuite {
  import Foo._
  test("compare ints") {
    assert(Equal[Int].equal(1, 1))
  }
  test("compare ints again") {
    assert(1 === 1)
  }
  test("compare Persons") {
    val a: Person = Person("Alice", "a@fake.com")
    val b: Person = Person("Alice", "a@fake.com")
    assert(a equal b)
  }

  test("Compare Persons again") {
    val a: Person = Person("Bob", "b@fake.com")
    val b: Person = Person("Bob", "b@fake.com")
    assert(a === b)
  }

}