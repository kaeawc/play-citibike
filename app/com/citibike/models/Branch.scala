package com.citibike.models

import play.api.libs.json._

case class Branch(
  id        : Long,
  latitude  : Float,
  longitude : Float,
  label     : String
)

object Branch extends ((
  Long,
  Float,
  Float,
  String
) => Branch) {
  
  implicit val r = Json.reads[Branch]
  implicit val w = Json.writes[Branch]

}
