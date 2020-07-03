package com.zsoltbalvanyos.ontrack

import cats.effect.IO
import _6.MyAlg
import _6.MyProg
import org.scalatest.{FlatSpec, Matchers}

class MyProgSpec extends FlatSpec with Matchers {

  "myProg" should "double the integer it receives" in {
    var result = 0;

    val myAlg = new MyAlg[IO] {
      override def insertItSomewhere(someInt: Int): IO[Unit] = IO.pure{result = someInt}
      override def doSomething(someInt: Int): IO[Int] = IO.pure(someInt * 2)
    }

    val myProg = new MyProg(myAlg)

    myProg.checkThenAddIt(5).unsafeRunSync()
    assert(result == 10)

    myProg.checkThenAddIt(0).unsafeRunSync()
    assert(result == 0)
  }

}
