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
