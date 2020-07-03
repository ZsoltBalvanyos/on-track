package com.zsoltbalvanyos.ontrack

object _3 {
  def increment(number: Seq[Int]): Seq[Int] = {
    if (number == Nil) return Nil

    case class Step(acc: Seq[Int], remainder: Int)

    val lastStep = number.foldRight(Step(Seq(), 1))((elem, step) =>
      if (elem + step.remainder == 10)
        Step(step.acc :+ 0, 1)
      else
        Step(step.acc :+ elem + step.remainder, 0))

    if (lastStep.remainder == 1) {
      (lastStep.acc :+ 1).reverse
    } else {
      lastStep.acc.reverse
    }
  }
}
