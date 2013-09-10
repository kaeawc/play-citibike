package com.citibike.api

import play.api.libs.json._
import com.citibike.models._

case class GetBranchesResponse(
  ok      : Boolean,
  meta    : Array[String],
  results : Array[Branch]
) extends com.citibike.CitibikeResponse

object GetBranchesResponse extends ((
  Boolean,
  Array[String],
  Array[Branch]
) => GetBranchesResponse) {
  
  implicit val r = Json.reads[GetBranchesResponse]
  implicit val w = Json.writes[GetBranchesResponse]

  def parse(data:String):Option[GetBranchesResponse] = {
    try {
      Some(Json.fromJson(Json.parse(data)).get)
    } catch {
      case e:Exception => None
    }
  }

}