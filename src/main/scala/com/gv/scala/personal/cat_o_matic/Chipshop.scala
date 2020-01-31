package com.gv.scala.personal.cat_o_matic

object Chipshop {
  def willServe(cat: Cat): Boolean =
    if(cat.food == "Chips")
      true
    else
      false
}
