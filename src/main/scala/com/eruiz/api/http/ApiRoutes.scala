package com.eruiz.api.http

import com.eruiz.api.JsonSupport
import com.eruiz.api.http.route.{HelloService, SwaggerSiteService}
import com.eruiz.api.service.SwaggerDocService

trait ApiRoutes extends HelloService
  with SwaggerSiteService
  with JsonSupport {

  import com.eruiz.implicits.ApiImplicits._

  lazy val route =
      helloRoute ~
      new SwaggerDocService(system).routes ~
      swaggerSiteRoute
}
