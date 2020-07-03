package com.zsoltbalvanyos.ontrack

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object _1 {
  def f1 : Future[Unit] = ???
  def f2 : Future[Unit] = ???
  def f3 : Future[Unit] = ???
  def f4 : Future[Unit] = ???

  // there are no dependencies between the functions
  f1
  f2
  f3
  f4

  // f4 depends on f3 which depends on f2 which depends on f1
  for {
    _ <- f1
    _ <- f2
    _ <- f3
    _ <- f4
  } yield ()

  // f4 depends on f3 and f2, and f3 and f2 both depend on f1
  for {
    _ <- f1
    _ <- Future.sequence(Seq(f2, f3))
    _ <- f4
  } yield ()

}
