package com.citibike.api

import play.api.libs.json._
import com.citibike.models._

case class GetHelmetsRequest(
  offset  : Option[Int] = None,
  limit   : Option[Int] = None,
  jsonp   : Option[String] = None
) extends com.citibike.api.GetItem[GetHelmetsResponse] {

  val resource = "/v1/helmet/list"
  def parse(data:String) = GetHelmetsResponse.parse(data)

}

object GetHelmetsRequest extends ((
  Option[Int],
  Option[Int],
  Option[String]
) => GetHelmetsRequest) {
  
  implicit val r = Json.reads[GetHelmetsRequest]
  implicit val w = Json.writes[GetHelmetsRequest]

}
