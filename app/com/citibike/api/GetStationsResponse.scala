package com.citibike.api

import play.api.libs.json._
import com.citibike.models._

case class GetStationsResponse(
  ok      : Boolean,
  meta    : Array[String],
  results : Array[Station]
) extends com.citibike.CitibikeResponse

object GetStationsResponse extends ((
  Boolean,
  Array[String],
  Array[Station]
) => GetStationsResponse) {
  
  implicit val r = Json.reads[GetStationsResponse]
  implicit val w = Json.writes[GetStationsResponse]

  def parse(data:String):Option[GetStationsResponse] = {
    try {
      Some(Json.fromJson(Json.parse(data)).get)
    } catch {
      case e:Exception => None
    }
  }

}