package com.citibike.models

import play.api.libs.json._

case class NearbyStation(
  id       : Long,
  distance : Float
)

object NearbyStation extends ((
  Long,
  Float
) => NearbyStation) {
  
  implicit val r = Json.reads[NearbyStation]
  implicit val w = Json.writes[NearbyStation]

}