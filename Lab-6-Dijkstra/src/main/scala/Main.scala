import scala.collection.mutable
import scala.io.StdIn._

object Main extends App{
  println("Введите кол-во вершин")
  val n = readInt()
  println("Введите кол-во рёбер")
  val m = readInt()
  val edges = mutable.Map.empty[Int,List[(Int,Int)]]
  println("Введите ребра в формате \"from to cost\"")
  for (i <- 1 to m) {
    val Array(from,to,cost) = readLine split " " map (_ toInt)
    if(edges contains from) edges += (from -> (edges(from) :+ (to,cost)))
    else edges += (from -> List((to,cost)))
  }
  println("Введите стартовую вершину")
  val from = readInt()
  val result = Dijkstra(n,edges toMap,from)
  println("Результат: ")
  for(i <- 1 to n){
    if(result contains i) println(s"$i ${result(i)._1} {${result(i)._2.mkString("->")}}")
  }
}