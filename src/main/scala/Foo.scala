package notes

object Foo {

  sealed trait Equal[A] {
    def equal(x: A, y: A): Boolean
  }

  implicit val IntEqual: Equal[Int] = new Equal[Int] {
    def equal(x: Int, y: Int): Boolean = x == y
  }

  final case class Person(name: String, email: String)

  implicit object PersonEqual extends Equal[Person] {
    def equal(x: Person, y: Person): Boolean = {
      x.name == y.name &&
        x.email == y.email
    }
  }

  object Equal {
    def apply[A](implicit instance: Equal[A]): Equal[A] = instance
    //Use like Equal[Int].equal(1,1)
  }
  
  //def implicitly[A](implicit value: A): A = value


  implicit class EqualOps[A: Equal](lt: A) { //can have a single parameter
    def ===(rt: A): Boolean = Equal[A].equal(lt, rt)
    def equal(rt: A): Boolean = Equal[A].equal(lt, rt)
  }
}