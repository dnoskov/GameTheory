import scala.collection.mutable.ArrayBuffer
import scala.io.Source
object UDMain {
  def main(args: Array[String]): Unit = {
    if (args.length < 4) {
      println("Не хватает аргументов")
    }
    else {

    }
  }


  def getData(filename: String, args: Array[Double]): ArrayBuffer[ArrayBuffer[Double]] = {
    val m = ArrayBuffer[ArrayBuffer[Double]]()
    for (l <- Source.fromFile(filename, "UTF-8").getLines()) {
      var i = 0
      m += ArrayBuffer[Double]()
      for (n <- l.split("\\s+")) {
        m(i) += n.toDouble
      }
      i += 1
    }
    return m
  }

  def attenuateData(a: ArrayBuffer[ArrayBuffer[Double]], args: Array[String]): Unit = {

  }
}