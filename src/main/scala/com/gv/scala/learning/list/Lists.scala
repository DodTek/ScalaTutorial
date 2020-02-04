package com.gv.scala.learning.list
import scala.annotation.tailrec

object Lists {

  @tailrec
  def last[A](list: List[A]): A = list match {
    //case List.empty[A]
      //head is first element of list tail is a sublist of list after head is taken out
      //_ is everything
    case Nil => throw new NoSuchElementException //no elements: list empty: list()
    case head:: Nil => head //if there is one element i.e last("b")
    case _::  tail => last(tail) //more than one element
  }
  @tailrec
  def lenght[A](list: List[A], lenght_x: Int): Int = list match {

    case Nil => 0
    case head:: Nil => lenght_x + 1//if there is one element i.e last("b")
    case _ :: tail => lenght(tail, lenght_x + 1) //more than one element

  }
  @tailrec
  def isPalindrome(list:List[Int]):Boolean =
  {
    list match {
      case Nil => true//if list is empty list return true
      case head:: Nil => isPalindrome(list.tail) //if list has one element return true
      case list => (list.head == list.last && isPalindrome(list.tail.init))//if list contains multiple elements check if
        //list head equals last element then recursively check the other elements
        //note: head "removes" first element (1,2,3,2,1) becomes list(2,3,2,1)
        //note: list.tail.init removes the tail i.e list(1,2,3,2,1) becomes list(1,2,3,2) after tail.init used

    }
  }

  @tailrec
  def reverseList[A](result : List[A], list : List[A]) : List[A] = {
    list match {
      case Nil => result
      case (head :: tail) =>  reverseList(head :: result, tail)
    }
  }
  /*
  def flatten(list: List[Any]) : List[Any] = {
    list match {
      case Nil => Nil
      case head :: tail => head match {
        case head :: tail => flatten(tail)
      }
        flatten(tail)
    }
    }
   */

  def flatten2(list: List[Any]): List[Any] = list match {
    case List() => Nil //if list empty return Nil

    case head :: tail => {//if list has a head and tail
      head match {//match head
        case head: List[Any] => flatten2(head)//if head has a "tail" of any list flatten head
        case _ => List(head) //if everything make list containing head
      }
    } ::: flatten2(tail)//flatten tail and append to list head which should now be flattened
    case _ => List(list)//if everything return list which should be flattened list of head and tail
  }

}
