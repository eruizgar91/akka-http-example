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
package com.eruiz.implicits

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import com.eruiz.constants.Constants
import com.typesafe.config.{Config, ConfigFactory, ConfigResolveOptions}

object ApiImplicits extends Constants{
  lazy implicit val executionContext = scala.concurrent.ExecutionContext.Implicits.global
  lazy implicit val config: Config = ConfigFactory
    .load(getClass.getClassLoader,
      ConfigResolveOptions.defaults.setAllowUnresolved(true))
    .resolve
  lazy implicit val system: ActorSystem = ActorSystem(AkkaClusterName, config)
  lazy implicit val materializer = ActorMaterializer()

}
