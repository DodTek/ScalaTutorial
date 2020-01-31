package com.gv.scala.learning.list

object List {
  def last[A](list: List[A]): A = list(list.length - 1)
}
