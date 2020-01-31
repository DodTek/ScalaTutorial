package com.gv.scala.personal

import com.gv.scala.personal.cat_o_matic.Cat

object ChipShop {
  def willServe(cat: Cat): Boolean =
    if(cat.food == "Chips")
      true
    else
      false
}
