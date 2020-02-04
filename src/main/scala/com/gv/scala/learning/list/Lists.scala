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
      case Nil => true
      //case {list.head != list.last} => false
      case head:: Nil => isPalindrome(list.tail)
      case list => (list.head == list.last && isPalindrome(list.tail.init))
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
    case List() => Nil
    case head :: tail => {
      head match {
        case head: List[Any] => flatten2(head)
        case _ => List(head)
      }
    } ::: flatten2(tail)
    case _ => List(list)
  }

}
