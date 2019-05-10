import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
object Apr19 {

  val x = () => (2 + 4) + 6 * 3
  
  def eval(f: () => Int): Int = f()
  
  // 1 - Algebra
  sealed trait Expr
  final case class Lit(x: Int) extends Expr
  final case class Add(x: Expr, y: Expr) extends Expr
  final case class Multiply(x: Expr, y: Expr) extends Expr
  
  // 2 - Program
  val program: Expr = Multiply(Add(Lit(1), Lit(2)), Lit(4))
  
  // 3 - Interpreter 
  def eval2(ex: Expr): Int = ex match {
    case Lit(x) => x
    case Add(x, y) => eval2(x) + eval2(y)
    case Multiply(x, y) => eval2(x) * eval2(y)
  }

  def evalString(ex: Expr): String = ex match {
    case Lit(x) => x.toString
    case Add(x, y) => s"(${evalString(x)} add ${evalString(y)})"
    case Multiply(x, y) => s"(${evalString(x)} mul ${evalString(y)})"
  }

  def eval3(ex: Expr): Future[Int] = ex match {
    case Lit(x) => Future(x)
    case Add(x, y) => eval3(x) + eval3(y)
    case Multiply(x, y) => eval3(x) * eval3(y)
  }
}
