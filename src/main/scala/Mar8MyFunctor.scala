package notes

object Mar8MyFunctor {

  final case class Person(age: Int, name: String)
  
  sealed trait Equal[T] {
    def equal(x: T, y: T): Boolean
  }
  
  implicit object personEqual extends Equal[Person] {
    def equal(x: Person, y: Person): Boolean = x.name == y.name 
  }

  implicit object intEqual extends Equal[Int] {
    def equal(x: Int, y: Int): Boolean = x == y
  }

  object Equal {
    def apply[A](implicit instance: Equal[A]): Equal[A] = instance
  }
  
  
  //F[A]
  // A => B   
  // F[B]
  
  //List[String]
  //_.length
  //List[Int]
  
  val xs: List[Int] = List("one", "two", "three").map(_.length)
}
