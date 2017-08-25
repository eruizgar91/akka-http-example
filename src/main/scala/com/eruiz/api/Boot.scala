package com.eruiz.api

import akka.http.scaladsl.Http
import com.eruiz.api.http.ApiRoutes
import com.typesafe.scalalogging.LazyLogging

import scala.util.{Failure, Success, Try}

object Boot extends App with LazyLogging with ApiRoutes {

  import com.eruiz.implicits.ApiImplicits._

  val host = Try(config.getString("host")).getOrElse(DefaultHost)
  val port = Try(config.getInt("port")).getOrElse(DefaultPort)

  Http().bindAndHandle(route, host, port) onComplete {
    case Success(_) =>
      logger.info(s"Server is listening on $host:$port")
    case Failure(e) =>
      logger.error(s"Binding failed with error ${e.getMessage}")
      system.terminate
  }
}