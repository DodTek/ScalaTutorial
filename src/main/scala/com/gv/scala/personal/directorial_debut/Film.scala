package com.gv.scala.personal.directorial_debut

class Film (name:String, yearOfRelease:Int, imdRating:Double,director: Director){
  def directorsAge: Int = yearOfRelease - director.yearOfBirth

  def isDirectedBy(director: Director): Boolean = this.director == director

  def copy(name:String= this.name,
           yearOfRelease:Int = this.yearOfRelease,
           imdRating:Double = this.imdRating,
           director: Director = this.director): Film = new Film(name,yearOfRelease,imdRating,director)
}
