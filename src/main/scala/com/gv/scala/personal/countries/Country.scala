package com.gv.scala.personal.countries

case class Country(name: String, population: Int = 0)

case object Country {
  val India: Country = Country("India", 1000000000)
  val Ireland: Country = Country("Ireland", 4000000)
  val Lithuania: Country = Country("Lithuania")
  val China: Country = Country("China", 2000000000)
  val England: Country = Country("England")

  def Report(): Unit = {
    println("Report")
    println(Ireland)
    println(England)
    println(Lithuania)
    println(China)
    println(India)

  }
}
