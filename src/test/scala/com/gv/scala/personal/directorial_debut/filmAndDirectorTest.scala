package com.gv.scala.personal.directorial_debut

import org.scalatest.wordspec.AnyWordSpec

class filmAndDirectorTest extends AnyWordSpec {
  val eastwood = new Director("Clint", "Eastwood", 1930)
  val mcTiernan = new Director("John", "McTiernan", 1951)
  "A Director" when {
    "first name function is called" should {
      "return first name" in {
        assertResult("Clint")(eastwood.firstName)
        assertResult("John")(mcTiernan.firstName)
      }
    }

    "second name function is called" should {
      "return last name" in {
        assertResult("Eastwood")(eastwood.lastName)
        assertResult("McTiernan")(mcTiernan.lastName)
      }
    }

    "last name function is called" should {
      "return date of birth" in {
        assertResult("Eastwood")(eastwood.lastName)
        assertResult(1951)(mcTiernan.yearOfBirth)
      }
    }
  }

  val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7, eastwood)
  val outlawJoseyWales  = new Film("The Outlaw Josey Wales", 1976, 7.9, eastwood)

  val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6, mcTiernan)
  val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8, mcTiernan)
}
