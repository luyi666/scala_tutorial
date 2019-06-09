object OperatorsDemo {
  case class Vec(x: Double, y: Double) {
    def +(that: Vec) = Vec(this.x + that.x, this.y + that.y)
  }

  case class MyBool(x: Boolean) {
    def and(that: MyBool): MyBool = if (x) that else this
    def or(that: MyBool): MyBool = if (x) this else that
    def negate: MyBool = MyBool(!x)
  }

  def not(x: MyBool): MyBool = x.negate
  def xor(x: MyBool, y: MyBool): MyBool = (x or y) and not(x and y)



  def main(args: Array[String]): Unit = {
    val vector1 = Vec(1.0, 1.0)
    val vector2 = Vec(2.0, 2.0)

    val vector3: Vec = vector1 + vector2
    println(vector3)
  }

  // Precedence
  /*
      (characters not shown below)
      * / %
      + -
      :
      = !
      < >
      &
      ^
      |
      (all letters)
   */
}
