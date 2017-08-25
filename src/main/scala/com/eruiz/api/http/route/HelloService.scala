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
package com.eruiz.api.http.route

import javax.ws.rs.Path

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.{Directives, Route}
import io.swagger.annotations.{Api, ApiOperation}

@Api(value = "/hello", produces = "application/json", consumes = "application/json")
@Path("/hello")
trait HelloService extends Directives {

  @ApiOperation(value = "Return Hello greeting", notes = "", nickname = "Hello", httpMethod = "GET")
  def helloRoute: Route = pathPrefix("hello") {
    get {
      complete(HttpEntity(ContentTypes.`application/json`, s"""{"Say" : "name"}"""))
    }
  }

}
