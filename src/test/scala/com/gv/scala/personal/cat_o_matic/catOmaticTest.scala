package com.gv.scala.personal.cat_o_matic

import org.scalatest.wordspec.AnyWordSpec

import org.scalatest.wordspec.AnyWordSpec

class catOmaticTest extends AnyWordSpec {

  var henderson = new Cat("Ginger", "Chips")

  var oswald= new Cat("Black", "Milk")
  "A chip shop" when {
    "will Serve is called" should {
      "return boolean " in {
        assertResult(false)(Chipshop.willServe(oswald))
        assertResult(true)(Chipshop.willServe(henderson))
      }
    }
  }
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
