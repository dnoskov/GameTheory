object Dijkstra {

  def apply(n: Int, edges: Map[Int, List[(Int, Int)]], from: Int):  Map[Int, (Int, List[Int])] = dijkstra {
    1 to n map (_ ->(Int.MaxValue, List.empty[Int])) toMap
  }(edges)(0, List.empty[Int])(from)

  def dijkstra(verts: Map[Int, (Int, List[Int])])(edges: Map[Int, List[(Int, Int)]])(m: (Int, List[Int]))(node: Int): Map[Int, (Int, List[Int])] = {
    val prenode = verts(node)
    if (!(edges contains node))
      if (prenode._1 > m._1) verts + (node -> (m._1, m._2 :+ node)) else verts + (prenode._1 -> (prenode._1,prenode._2 :+ node))
    else if (prenode._1 > m._1) (edges(node) map {
        x => dijkstra(verts + (node -> (m._1, m._2 :+ node)))(edges)(m._1 + x._2, m._2 :+ node)(x._1) toList
      } reduce (_ ++ _) groupBy (_._1) map (_._2 minBy (_._2._1)))
    else verts + (prenode._1 -> (prenode._1,prenode._2 :+ node))
  }
}
