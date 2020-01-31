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
}
