// in file PrintPlanted.scala
import gardening.fruits._
object PrintPlanted {
  def main(args: Array[String]): Unit = {
    for (fruit <- gardening.fruits.planted) {
      showFruit(fruit)
    }
  }
}