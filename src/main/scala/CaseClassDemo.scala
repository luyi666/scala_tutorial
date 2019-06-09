object CaseClassDemo {
  //When you create a case class with parameters, the parameters are public vals.
  case class Book(isbn: String)
  case class Message(sender: String, recipient: String, body: String)

  def main(args: Array[String]): Unit = {
    val frankenstein = Book("978-0486282114")
    val message1 = Message("guillaume@quebec.ca", "jorge@catalonia.es", "Ça va ?")
    println(message1.sender)  // prints guillaume@quebec.ca

    // Case classes are compared by structure and not by reference
    val message2 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
    val message3 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
    val messagesAreTheSame: Boolean = message2 == message3  // true
    println(messagesAreTheSame)

    // shallow copy
    val message4 = Message("julien@bretagne.fr", "travis@washington.us", "Me zo o komz gant ma amezeg")
    val message5: Message = message4.copy(sender = message4.recipient, recipient = "claire@bourgogne.fr")
    println(message5)
  }
}
