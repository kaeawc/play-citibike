package com.citibike.api

import play.api.libs.json._
import com.citibike.models._

case class GetHelmetsResponse(
  ok      : Boolean,
  meta    : Array[String],
  results : Array[Helmet]
) extends com.citibike.CitibikeResponse

object GetHelmetsResponse extends ((
  Boolean,
  Array[String],
  Array[Helmet]
) => GetHelmetsResponse) {
  
  implicit val r = Json.reads[GetHelmetsResponse]
  implicit val w = Json.writes[GetHelmetsResponse]

  def parse(data:String):Option[GetHelmetsResponse] = {
    try {
      Some(Json.fromJson(Json.parse(data)).get)
    } catch {
      case e:Exception => None
    }
  }

}

