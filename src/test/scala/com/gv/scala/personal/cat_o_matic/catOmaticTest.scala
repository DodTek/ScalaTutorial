package com.gv.scala.personal.cat_o_matic

import org.scalatest.wordspec.AnyWordSpec

import org.scalatest.wordspec.AnyWordSpec

class catOmaticTest extends AnyWordSpec {
  /*
  chipper = new Chipshop
  "A chip shop" when {
    "willServe is called" should {
      "return boolean " in {
        assertResult("Clint")(eastwood.firstName)
        assertResult("John")(mcTiernan.firstName)
      }
    }
  }
  */
  var henderson = new Cat("Ginger", "Chips")
  "A cat" when {
    "created" should {
      "have a colour" in {
        assertResult("Ginger")(henderson.colour)
      }
      "have a food" in {
        assertResult("Chips")(henderson.food)
      }
    }
  }

}
