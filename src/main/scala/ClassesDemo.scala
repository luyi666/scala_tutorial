object ClassesDemo {
  class User

  val user1 = new User

  class Point() {
    private var _x = 0
    private var _y = 0
    private val bound = 100

    def x: Int = _x
    def x_= (newValue: Int): Unit = {
      if (newValue < bound) _x = newValue else printWarning
    }

    def y: Int = _y
    def y_= (newValue: Int): Unit = {
      if (newValue < bound) _y = newValue else printWarning
    }

    private def printWarning(): Unit = println("WARNING: Out of bounds")

    def move(dx: Int, dy: Int): Unit = {
      _x = _x+ dx
      _y = _y + dy
    }

    override def toString: String = {
      s"($x, $y)"
    }
  }

  def main(args: Array[String]): Unit = {
    val point1 = new Point()
    point1.x = 2 // 2
    point1.y = 3
    point1.move(1,1)
    println(point1)
  }

}
