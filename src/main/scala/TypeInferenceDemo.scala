object TypeInferenceDemo {
  def main(args: Array[String]): Unit = {
    val businessName = "Montreux Jazz Café"
    def squareOf(x: Int) = x * x
    case class MyPair[A, B](x: A, y: B)
    val p = MyPair(1, "scala") // type: MyPair[Int, String]

    def id[T](x: T) = x
    val q = id(1)              // type: Int
  }
}
