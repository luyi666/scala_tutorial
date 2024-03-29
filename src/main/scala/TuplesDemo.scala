object TuplesDemo {
  def main(args: Array[String]): Unit = {
    val ingredient = ("Sugar", 25)
    println(ingredient._1, ingredient._2)
    val (name, quantity) = ingredient
    println(name) // Sugar
    println(quantity) // 25

    val planets =
      List(("Mercury", 57.9), ("Venus", 108.2), ("Earth", 149.6),
        ("Mars", 227.9), ("Jupiter", 778.3))
    planets.foreach{
      case ("Earth", distance) =>
        println(s"Our planet is $distance million kilometers from the sun")
      case (planet, distance) =>
        println(s"The planet $planet is $distance  million kilometers from the sun")
    }

    val numPairs = List((2, 5), (3, -7), (20, 56))
    for ((a, b) <- numPairs) {
      println(a * b)
    }
  }
}
