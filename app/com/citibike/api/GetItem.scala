package com.citibike.api

import com.citibike._

trait GetItem[Response<:CitibikeResponse] extends com.citibike.CitibikeRequest[Response] {

  val method = "get"

}
