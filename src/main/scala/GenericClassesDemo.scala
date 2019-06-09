object GenericClassesDemo {
  // Generic classes are classes which take a type as a parameter. They are particularly useful for collection classes.
  class Stack[A] {
    private var elements: List[A] = Nil
    def push(x: A) { elements = x :: elements }
    def peek: A = elements.head
    def pop(): A = {
      val currentTop = peek
      elements = elements.tail
      currentTop
    }
  }

  def main(args: Array[String]): Unit = {
    abstract class Fruit {
      def toString : String
    }
    class Apple extends Fruit {
      override def toString: String = {"this is apple"}
    }
    class Banana extends Fruit {
      override def toString: String = {"this is banana"}
    }

    val stack = new Stack[Fruit]
    val apple = new Apple
    val banana = new Banana

    stack.push(apple)
    stack.push(banana)
    println(stack.pop())
    println(stack.pop())
  }
}
