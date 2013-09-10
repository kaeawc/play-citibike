package com.citibike.models

import play.api.libs.json._

case class Helmet(
  id        : Long,
  address   : String,
  latitude  : Float,
  longitude : Float,
  label     : String
)

object Helmet extends ((
  Long,
  String,
  Float,
  Float,
  String
) => Helmet) {
  
  implicit val r = Json.reads[Helmet]
  implicit val w = Json.writes[Helmet]

}