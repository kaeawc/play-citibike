package com.citibike.models

import play.api.libs.json._

case class Station(
  id             : Long,
  status         : String,
  latitude       : Float,
  longitude      : Float,
  label          : String,
  stationAddress : String,
  availableBikes : Int,
  availableDocks : Int,
  nearbyStations : Array[NearbyStation]
)

object Station extends ((
  Long,
  String,
  Float,
  Float,
  String,
  String,
  Int,
  Int,
  Array[NearbyStation]
) => Station) {
  
  implicit val r = Json.reads[Station]
  implicit val w = Json.writes[Station]

}