/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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