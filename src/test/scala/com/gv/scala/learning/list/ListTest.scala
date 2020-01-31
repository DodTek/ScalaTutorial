package com.gv.scala.learning.list

import org.scalatest.wordspec.AnyWordSpec

class ListTest extends AnyWordSpec {
  "A list" when {
    "not empty" should {
      "yield the last element as requested " in{
        assertResult(5)(Lists.last(List(1,2,3,4,5)))
        assertResult("b")(Lists.last(List("a","b")))
      }
    }
    "empty" should {
        "throws a NoSuchElement exception when last element is requested" in {
          assertThrows[NoSuchElementException](Lists.last(List()))
        }
    }
  }
}
