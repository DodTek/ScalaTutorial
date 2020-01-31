package com.gv.scala.learning.list.cat_o_matic

object ChipShop {
  def willServe(cat: Cat): Boolean =
    if(cat.food == "Chips")
      true
    else
      false
}
