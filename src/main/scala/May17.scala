import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object May17 {

  /*
  // 1 - Algebra
  sealed trait Expr
  final case class Lit(x: Int) extends Expr
  final case class Add(x: Expr, y: Expr) extends Expr
  final case class Multiply(x: Expr, y: Expr) extends Expr

  // 2 - Program
  val program: Expr = Multiply(Add(Lit(1), Lit(2)), Lit(4))
  */
  
  sealed trait ExprDSL {
    def literal[A](x: A): A
    def lessThan(x: Int, y: Int): Boolean
    def and(x: Boolean, y: Boolean): Boolean
  }
  
  def run(program: ExprDSL): Boolean = {
    import program._
    and(lessThan(literal(1), literal(2)),lessThan(literal(2), literal(3)))
  }
  
  object Interp extends ExprDSL {
    def literal[A](x: A): A = x

    def lessThan(x: Int, y: Int): Boolean = x < y

    def and(x: Boolean, y: Boolean): Boolean = x && y
  }
}
