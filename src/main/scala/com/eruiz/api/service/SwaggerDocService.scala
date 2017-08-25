package com.eruiz.api.service

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import com.eruiz.api.http.route.HelloService
import com.eruiz.constants.Constants
import com.github.swagger.akka.{HasActorSystem, SwaggerHttpService}
import com.github.swagger.akka.model.Info
import io.swagger.models.ExternalDocs
import io.swagger.models.auth.BasicAuthDefinition

import scala.reflect.runtime.{universe => ru}


class SwaggerDocService(system: ActorSystem) extends SwaggerHttpService with HasActorSystem with Constants {
  override implicit val actorSystem: ActorSystem = system
  override implicit val materializer: ActorMaterializer = ActorMaterializer()
  override val apiTypes = Seq(ru.typeOf[HelloService])
  override val host = s"$DefaultHost:$DefaultPort"
  override val info = Info(version = "1.0")
  override val externalDocs = Some(new ExternalDocs("Core Docs", "http://acme.com/docs"))
  override val securitySchemeDefinitions = Map("basicAuth" -> new BasicAuthDefinition())
}
