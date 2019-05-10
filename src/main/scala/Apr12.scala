import cats._

object Apr12 {
  //map : F[A] => (A => B) => F[B] //covariant functor === Functor
  // F[B] => (A => B) => F[A] // contravariant functor
  
  trait Printable[A] {
    self =>
    //(A => String)
    def format(x: A): String
    
    //
    def contramap[B](f: B => A): Printable[B] =  new Printable[B] {
      def format(x: B): String = self.format(f(x))
    }
    
  }
  
  def format[A](value: A)(implicit b: Printable[A]): String = b.format(value)

  
}
