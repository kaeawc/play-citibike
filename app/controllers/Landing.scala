package controllers

import play.api._
import play.api.mvc._

object Landing extends Controller {

  def get = Action {
    Ok(views.html.landing())
  }

}