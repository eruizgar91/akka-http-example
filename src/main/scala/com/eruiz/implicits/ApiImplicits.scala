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
