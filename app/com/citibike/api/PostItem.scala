package com.citibike.api

import com.citibike._

trait PostItem[Response<:CitibikeResponse] extends com.citibike.CitibikeRequest[Response] {

  val method = "post"

}
