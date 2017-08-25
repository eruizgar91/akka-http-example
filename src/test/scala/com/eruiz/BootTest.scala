/*
 * Copyright (C) 2015 Stratio (http://stratio.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Route
import org.junit.runner.RunWith
import akka.http.scaladsl.testkit.ScalatestRouteTest
import com.eruiz.api.http.ApiRoutes
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Matchers, WordSpec}

@RunWith(classOf[JUnitRunner])
class BootTest extends WordSpec
  with Matchers
  with ScalatestRouteTest
  with ApiRoutes {

    "ZookeeperRoute" should {
        "handle get" in {
            Get("/hello") ~> route ~> check {
                response.status shouldBe StatusCodes.OK
            }
        }
        "do not handle when post" in {
            Post("/hello", "") ~> route ~> check {
                handled shouldBe false
            }
        }
    }
    "SwaggerSiteService" should {
        "handle get" in {
            Get("/swagger") ~> route ~> check {
                response.status shouldBe StatusCodes.OK
            }
        }
        "do not handle when post" in {
            Post("/swagger", "") ~> route ~> check {
                handled shouldBe false
            }
        }
    }
    "SwaggerDocService" should {
        "handle get" in {
            Get("/api-docs/swagger.json") ~> route ~> check {
                response.status shouldBe StatusCodes.OK
            }
        }
    }
    "Not allowed method" should {
        "return a MethodNotAllowed error for PUT request" in {
            Put() ~> Route.seal(route) ~> check {
                status === StatusCodes.MethodNotAllowed
                responseAs[String] shouldEqual "The requested resource could not be found."
            }
        }
    }

}
