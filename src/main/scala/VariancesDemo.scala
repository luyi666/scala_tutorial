object VariancesDemo {
  // Covariance
  abstract class Animal {
    def name: String
  }
  case class Cat(name: String) extends Animal
  case class Dog(name: String) extends Animal

  def printAnimalNames(animals: List[Animal]): Unit = {
    animals.foreach { animal =>
      println(animal.name)
    }
  }

  // Contravariance
  abstract class Printer[-A] {
    def print(value: A): Unit
  }
  class AnimalPrinter extends Printer[Animal] {
    def print(animal: Animal): Unit =
      println("The animal's name is: " + animal.name)
  }

  class CatPrinter extends Printer[Cat] {
    def print(cat: Cat): Unit =
      println("The cat's name is: " + cat.name)
  }

  // Invariance
  class Container[A](value: A) {
    private var _value: A = value
    def getValue: A = _value
    def setValue(value: A): Unit = {
      _value = value
    }
  }


  def main(args: Array[String]): Unit = {
    // Covariance
    val cats: List[Cat] = List(Cat("Whiskers"), Cat("Tom"))
    val dogs: List[Dog] = List(Dog("Fido"), Dog("Rex"))
    printAnimalNames(cats)
    // Whiskers
    // Tom
    printAnimalNames(dogs)
    // Fido
    // Rex

    // Contravariance
    val myCat: Cat = Cat("Boots")

    def printMyCat(printer: Printer[Cat]): Unit = {
      printer.print(myCat)
    }

    val catPrinter: Printer[Cat] = new CatPrinter
    val animalPrinter: Printer[Animal] = new AnimalPrinter

    printMyCat(catPrinter)
    printMyCat(animalPrinter)
  }
}
