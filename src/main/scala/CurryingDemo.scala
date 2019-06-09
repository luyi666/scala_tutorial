object CurryingDemo {
  def main(args: Array[String]): Unit = {
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val res = numbers.foldLeft(0)((m, n) => m + n)
    println(res) // 55

    val numberFunc = numbers.foldLeft(List[Int]()) _
    val squares = numberFunc((xs, x) => xs :+ x*x)
    val cubes = numberFunc((xs, x)=> xs:+x*x*x)
    println(squares)
    println(cubes)
  }
}
