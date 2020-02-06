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
      case head:: Nil => true //if list has one element return true
      case list => (list.head == list.last && isPalindrome(list.tail.init))//if list contains multiple elements check if
        //list head equals last element then recursively check the other elements
        //note: head "removes" first element (1,2,3,2,1) becomes list(2,3,2,1)
        //note: list.tail.init removes the tail i.e list(1,2,3,2,1) becomes list(1,2,3,2) after tail.init used

    }
  }

  @tailrec
  def reverseList[A](result : List[A], list : List[A]) : List[A] = {
    list match {
      case Nil => result //if empty return result which is empty
      case (head :: tail) =>  reverseList(head :: result, tail)//add head to result and tail as the list to check
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
        case head: List[Any] => flatten2(head)//if head has a "tail" of any list flatten head and return it
        case _ => List(head) //if everything make list containing head which should be flat and return it
      }
    } ::: flatten2(tail)//flatten tail and append to list head which should now be flattened then return that list
    case _ => List(list)//if everything return list which should be a flat list
  }

  def divide(list: List[Any]): List[Any] = list match {
    case List() => Nil //if list empty return Nil
    case head :: tail => List(List(head)) ::: divide(tail)
  }

  def pack[A](list: List[A]): List[List[A]] = {
    def packRec(acc: List[A], input: List[A]): List[List[A]] = input match {
      case Nil => Nil
      case x :: xs => xs match {
        case Nil => List(acc)
        case y :: _ =>
          if (x == y) packRec(x :: acc, xs)
          else acc :: packRec(List(y),xs)
      }
    }
    val acc = if(list.isEmpty) Nil else list.head :: Nil

    packRec(acc,list)
  }

  def encode[A](input:List[A]): List[(Int,A)] = {
    pack(input) map(e => (e.length,e.head))
  }

  def encodeV2[A](input:List[A]): List[Any] = {
    pack(input) map(e => (if (e.length == 1)  e else (e.length,e.head)))
  }

}
