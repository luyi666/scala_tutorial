object HigherOrderFuncDemo {
  val doubleSalary: Double => Double = (x: Double) => x * 2


  // Coercing methods into functions
  case class WeeklyWeatherForecast(temperatures: Seq[Double]) {

    private def convertCtoF(temp: Double) = temp * 1.8 + 32

    def forecastInFahrenheit: Seq[Double] = temperatures.map(convertCtoF) // <-- passing the method convertCtoF
  }

  // Functions that accept functions
  object SalaryRaiser {

    private def promotion(salaries: Seq[Double], promotionFunction: Double => Double): Seq[Double] =
      salaries.map(promotionFunction)

    def smallPromotion(salaries: Seq[Double]): Seq[Double] =
      promotion(salaries, salary => salary * 1.1)

    def bigPromotion(salaries: Seq[Double]): Seq[Double] =
      promotion(salaries, salary => salary * math.log(salary))

    def hugePromotion(salaries: Seq[Double]): Seq[Double] =
      promotion(salaries, salary => salary * salary)
  }

  // Functions that return functions
  def urlBuilder(ssl: Boolean, domainName: String): (String, String) => String = {
    val schema = if (ssl) "https://" else "http://"
    (endpoint: String, query: String) => s"$schema$domainName/$endpoint?$query"
  }

  def main(args: Array[String]): Unit = {
    val salaries = Seq(20000.0, 70000.0, 40000.0)
    val newSalaries = salaries.map(doubleSalary) // List(40000, 140000, 80000)
    newSalaries.foreach(println)

    val weeklyWeather = WeeklyWeatherForecast(Seq(1, 2, 3, 4))
    println(weeklyWeather.forecastInFahrenheit)

    println(SalaryRaiser.bigPromotion(salaries))
    println(SalaryRaiser.smallPromotion(salaries))
    println(SalaryRaiser.hugePromotion(salaries))

    val domainName = "www.example.com"
    def getURL: (String, String) => String = urlBuilder(ssl=true, domainName)
    val endpoint = "users"
    val query = "id=1"
    val url = getURL(endpoint, query) // "https://www.example.com/users?id=1": String
    println(url)
  }
}
