package com.eruiz.api

import org.json4s.{DefaultFormats, Formats}

trait JsonSupport {

  implicit val json4sFormats: Formats = DefaultFormats
}
