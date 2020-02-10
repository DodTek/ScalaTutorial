package com.gv.scala.personal.countries
import scala.util.Try

case class Person(name: String,country: Country,age: Int) {
  def introduce = s"Hello I'm $name,I am $age, and I come from $country"
}
object Person {
  import  Country._
  val people: List[Person] = List(
    Person(name = "Donnchadh", country = Ireland, age = 21),
    Person(name = "Gayatri", country = India, age = 22),
    Person(name = "Qiuyang", country = China, age = 23),
    Person(name = "Sean", country = Ireland, age = 21),
    Person(name = "Mantvydas", country = Lithuania, age = 22),
    Person(name = "Neven", country = England, age = 23)
  )

  def average(ps: List[Person]): Try[Double] = {
    Try(ps.map(_.age).sum.toDouble / ps.size.toDouble)
  }

  def listPeople(pl: List[Person]): Unit = {
    pl.foreach(p => println(p.toString))
  }

  def Report(list: List[Person]): Unit = {
    println("Report")
    println("the average age for all people in Ireland" + average(list.filter(_.country == Ireland)))
    println("the average age for all people in England" + average(list.filter(_.country == England)))
    println("the average age for all people in Lithuania" + average(list.filter(_.country == Lithuania)))
    println("the average age for all people in China" + average(list.filter(_.country == China)))
    println("the average age for all people in India" + average(list.filter(_.country == India)))

    println(listPeople(list))
  }
}

