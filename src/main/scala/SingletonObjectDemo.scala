import logging.Logger.info

class Project(name: String, daysToComplete: Int)

object SingletonObjectDemo {
  // Companion objects
  import scala.math._

  case class Circle(radius: Double) {
    import Circle._
    def area: Double = calculateArea(radius)
  }

  object Circle {
    private def calculateArea(radius: Double): Double = Pi * pow(radius, 2.0)
  }

  // The companion object can also contain factory methods
  class Email(val username: String, val domainName: String)

  object Email {
    def fromString(emailString: String): Option[Email] = {
      emailString.split('@') match {
        case Array(a, b) => Some(new Email(a, b))
        case _ => None
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val project1 = new Project("TPS Reports", 1)
    val project2 = new Project("Website redesign", 5)
    info("Created projects")  // Prints "INFO: Created projects"

    val circle1 = new Circle(5.0)
    println(circle1.area)

    val scalaCenterEmail: Option[Email] = Email.fromString("scala.center@epfl.ch")
    scalaCenterEmail match {
      case Some(email) => println(
        s"""Registered an email
           |Username: ${email.username}
           |Domain name: ${email.domainName}
     """)
      case None => println("Error: could not parse email")
    }

    val scalaCenterEmailInvalid: Option[Email] = Email.fromString("scala.centerepfl.ch")
    scalaCenterEmailInvalid match {
      case Some(email) => println(
        s"""Registered an email
           |Username: ${email.username}
           |Domain name: ${email.domainName}
     """)
      case None => println("Error: could not parse email")
    }
  }

}