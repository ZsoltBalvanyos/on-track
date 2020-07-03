package com.zsoltbalvanyos.ontrack

import org.scalatest.{FlatSpec, Matchers}

class _3Spec extends FlatSpec with Matchers {

  it should "increment the represented integer by one" in {
    assert(_3.increment(Nil) === Nil)
    assert(_3.increment(Seq(0)) === Seq(1))
    assert(_3.increment(Seq(1, 2, 3)) === Seq(1, 2, 4))
    assert(_3.increment(Seq(9, 9, 9)) === Seq(1, 0, 0, 0))
  }

}
