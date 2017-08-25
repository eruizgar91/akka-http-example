package com.eruiz.api.http.route

import akka.http.scaladsl.server.Directives

trait SwaggerSiteService extends Directives {
  val swaggerSiteRoute = path("swagger") {
    getFromResource("swagger-ui/index.html")
  } ~
    getFromResourceDirectory("swagger-ui")
}