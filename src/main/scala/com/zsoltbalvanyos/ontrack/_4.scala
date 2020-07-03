package com.zsoltbalvanyos.ontrack

import scala.concurrent.Future
import scala.util.Try
import cats.implicits._

import scala.concurrent.ExecutionContext.Implicits.global

object _4 {
  def f[A](a: A): Future[A] = ???

  def g[A](a: A): Future[Either[Throwable, A]] = Try(f(a)).toEither.sequence
}
