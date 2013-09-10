package com.citibike.api

import play.api.libs.json._
import com.citibike.models._

case class GetBranchesRequest(
  offset  : Option[Int] = None,
  limit   : Option[Int] = None,
  jsonp   : Option[String] = None
) extends com.citibike.api.GetItem[GetBranchesResponse] {

  val resource = "/v1/branch/list"
  def parse(data:String) = GetBranchesResponse.parse(data)

}

object GetBranchesRequest extends ((
  Option[Int],
  Option[Int],
  Option[String]
) => GetBranchesRequest) {
  
  implicit val r = Json.reads[GetBranchesRequest]
  implicit val w = Json.writes[GetBranchesRequest]

}
