package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

  def get = Action {
    Ok(views.html.index())
  }

}