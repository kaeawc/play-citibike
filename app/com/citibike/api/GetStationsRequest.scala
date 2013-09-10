package com.citibike.api

import play.api.libs.json._
import com.citibike.models._

case class GetStationsRequest(
  offset  : Option[Int] = None,
  limit   : Option[Int] = None,
  jsonp   : Option[String] = None
) extends com.citibike.api.GetItem[GetStationsResponse] {

  val resource = "/data2/stations"
  def parse(data:String) = GetStationsResponse.parse(data)

}

object GetStationsRequest extends ((
  Option[Int],
  Option[Int],
  Option[String]
) => GetStationsRequest) {
  
  implicit val r = Json.reads[GetStationsRequest]
  implicit val w = Json.writes[GetStationsRequest]

}
