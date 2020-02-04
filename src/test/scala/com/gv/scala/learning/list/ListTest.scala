package com.gv.scala.learning.list

import org.scalatest.wordspec.AnyWordSpec

class ListTest extends AnyWordSpec {
  "A list" when {
    "contains a single element" should {
      "return its element as the last element" in {
        assertResult('b')(Lists.last('b' :: Nil))
      }
      "return the lenght of a list that equals 1" in {
        assertResult(1)(Lists.lenght(List("b"),0))
      }
    }
    "not empty" should {
      "yield the last element as requested " in {
        //List(1,2,3,4,5) = List(1 :: 2 :: 3 :: 4 :: 5 :: Nil
        assertResult(5)(Lists.last(List(1, 2, 3, 4, 5)))
        assertResult("b")(Lists.last(List("a","b")))
      }
      "yield the length of a list with multiple elements" in {
        //List(1,2,3,4,5) = List(1 :: 2 :: 3 :: 4 :: 5 :: Nil
        assertResult(5)(Lists.lenght(List(1, 2, 3, 4, 5),0))
      }
    }
    "empty" should {
      "throws a NoSuchElement exception when last element is requested" in {
        assertThrows[NoSuchElementException](Lists.last(List()))
      }
      "yields a 0 when the list is empty" in {
        assertResult(0)(Lists.lenght(List(),0))
      }
    }
    "is a Palindrome" should {
      "be true if empty" in {
        assertResult(true)(Lists.isPalindrome(List()))
      }
      "be true if there is one element" in {
        assertResult(true)(Lists.isPalindrome(List(1)))
      }
      "be true if really a palindrome,even number of elements" in {
        assertResult(true)(Lists.isPalindrome(List(1, 2, 3, 3, 2, 1)))

      }
      "be true if really a palindrome,odd number of elements" in {
        assertResult(true)(Lists.isPalindrome(List(1, 2, 3, 2, 1)))

      }
      "be false if not palindrome" in {
        assertResult(false)(Lists.isPalindrome(List(1, 2, 3, 4, 1)))
        assertResult(false)(Lists.isPalindrome(List(1, 2, 3, 4, 5)))
      }
    }

    "is reversed" should {
      "return reversed list" in {
        assertResult(List(3,2,1))(Lists.reverseList(Nil,List(1, 2, 3)))
      }
    }
  }
}
