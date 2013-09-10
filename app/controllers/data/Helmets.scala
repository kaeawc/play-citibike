package controllers.data

import play.api._
import play.api.mvc._
import play.api.libs.json._
import scala.concurrent.{Future,ExecutionContext}
import ExecutionContext.Implicits.global

object Helmets extends Controller {

  def list = Action.async {

    com.citibike.api.GetHelmets map {
      response =>

      response.map {
        list =>
        Ok(Json.toJson(list.results))
      }.getOrElse {
        NotFound
      }
    }
  }

}