package com.zsoltbalvanyos.ontrack

import cats.effect.Effect
import cats.implicits._

object _6 {

  trait MyAlg[F[_]] {
    def insertItSomewhere(someInt: Int): F[Unit]
    def doSomething(someInt: Int): F[Int]
  }

  class MyProg[F[_]](myAlg: MyAlg[F]) {
    def checkThenAddIt(someInt: Int)(implicit effect: Effect[F]): F[Unit] =
      effect.suspend(myAlg.doSomething(someInt)).flatMap(myAlg.insertItSomewhere)
  }

}
