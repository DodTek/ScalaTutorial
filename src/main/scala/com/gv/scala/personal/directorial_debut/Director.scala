package com.gv.scala.personal.directorial_debut

class Director(val firstName: String, val lastName: String, val yearOfBirth: Int){
  def name: String =
    s"$firstName $lastName"

  def copy(firstName: String = this.firstName, lastName: String = this.lastName, yearOfBirth: Int = this.yearOfBirth):
    Director = new Director(firstName, lastName, yearOfBirth)//returns copy of director
}
