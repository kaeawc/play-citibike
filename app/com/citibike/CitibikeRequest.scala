package com.citibike

import play.api.Play
import play.api.libs.ws._
import play.api.libs.ws.WS._
import scala.concurrent.Future
import scala.concurrent.{Future,ExecutionContext}
import ExecutionContext.Implicits.global

trait CitibikeRequest[Response<:CitibikeResponse] {
  
  val baseUrl = "http://appservices.citibikenyc.com/"
  val method:String
  def resource:String
  def parse(data:String):Option[Response]

  def process(response:play.api.libs.ws.Response):Option[Response] = {
    response.status match {
      case 200 => parse(response.body)
      case _ => handleError(response)
    }
  }
  def handleError(response:play.api.libs.ws.Response) = {

    val error = ErrorResponse.parse(response.body)

    val message = response.status match {
      case 404 => error.map { error => error.message }.getOrElse("Not found")
      case _   => error.map { error => error.message }.getOrElse("Unknown error")
    }

    throw new Exception(message)
  }
  def execute():Future[Option[Response]] = {
    WS.url(baseUrl + resource).get.map {
      response => process(response)
    }
  }
}