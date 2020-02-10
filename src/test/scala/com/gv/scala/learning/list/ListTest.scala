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

    "is flattened" should {
      "return an empty list if empty" in {
        assertResult(List())(Lists.flatten2(List()))
      }
      "return a unflattened list" in {
        assertResult(List(1,2,3))(Lists.flatten2(List(1, List(2, List(3)))))
        assertResult(List(1,2,3))(Lists.flatten2(List(List(1, List(2, List(3))))))
      }
    }
    "A list of symbols" when {
      "full" should {
        "divide each element into its own list in the list" in {
          assertResult(List(List('a'), List('a'), List('a'), List('a'), List('b'), List('c'), List('c'), List('d'), List('a'), List('a'), List('e'), List('e'), List('e'), List('e')))(Lists.divide(List('a','a','a','a','b','c','c','d','a','a','e', 'e', 'e', 'e')))
        }
        "pack the same element into their own list in the list" in {
          assertResult(List(List('a', 'a', 'a','a'), List('b'), List('c','c'), List('d'), List('a', 'a'), List('e', 'e', 'e', 'e')))(Lists.pack(List('a','a','a','a','b','c','c','d','a','a','e', 'e', 'e', 'e')))
        }
        "encode the same element into their own list in a list" in {
          assertResult(List((4,'a'), (1,'b'), (2,'c'), (2,'a'), (1,'d'), (4,'e')))(Lists.encode(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')))
        }
        "split into two parts based on a size passed in by function split" in {
          assertResult((List('a', 'b', 'c'),List('d', 'e', 'f', 'g', 'h', 'i', 'j', 'k')))(Lists.split(3, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')))
          //assertResult((List(1, 2, 3),List(4,5,6,7,8,9,10)))(Lists.split(3, List(1, 2,3,4,5,6,7,8,9,10)))
        }
        "slice into two parts based on a size passed" in {
          assertResult(List('d', 'e', 'f', 'g'))(Lists.slice(3, 7, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')))
        }
        "rotate the list by pushing elements to the left" in {
          assertResult(List('d', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'a', 'b', 'c'))(Lists.rotate(3,List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')))
          assertResult(List('j', 'k', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'))(Lists.rotate(-2, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')))
        }

        "remove an element from the list based on its place in the list" in {
          assertResult((List('a','c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'),'b'))(Lists.removeK(1,List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')))
        }
      }
      "empty" should {
        "return an empty list" in {
          assertResult(Nil)(Lists.divide(List()))
          assertResult(Nil)(Lists.pack(List()))
          assertResult(Nil)(Lists.encode(List()))
          assertResult((Nil,Nil) )(Lists.split(1,List()))
          assertResult(Nil)(Lists.slice(1,5,List()))
          assertResult(Nil)(Lists.rotate(1,List()))
          assertResult( (Nil,0) )(Lists.removeK(1,List()))


        }
      }
    }
  }
}
