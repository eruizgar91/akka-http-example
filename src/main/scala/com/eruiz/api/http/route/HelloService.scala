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
