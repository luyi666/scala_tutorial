object AnyTypeDemo {
  val list: List[Any] = List(
    "a string",
    732,  // an integer
    'c',  // a character
    true, // a boolean value
    () => "an anonymous function returning a string"
  )

  def main(args: Array[String]): Unit = {
    list.foreach(element => println(element))
  }
}

object TypeCastingDemo {
  val x: Long = 987654321
  val y: Float = x  // 9.8765434E8 (note that some precision is lost in this case)

  val face: Char = '☺'
  val number: Int = face  // 9786
  def main(args: Array[String]): Unit = {
    println(face)
    println(number)
  }
}