package com.citibike

import scala.concurrent.{Future,ExecutionContext}
import ExecutionContext.Implicits.global

package object api {
  def GetBranches:Future[Option[GetBranchesResponse]] =
    GetBranchesRequest().execute
  def GetHelmets:Future[Option[GetHelmetsResponse]] =
    GetHelmetsRequest().execute
  def GetStations:Future[Option[GetStationsResponse]] =
    GetStationsRequest().execute
}