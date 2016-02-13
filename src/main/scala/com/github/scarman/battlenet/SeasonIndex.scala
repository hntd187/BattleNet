package com.github.scarman.battlenet

import dispatch.Defaults._
import dispatch._
import org.json4s.JValue
import org.json4s.native.JsonMethods._

case class Season(href: String)

object SeasonIndex {

  val endpoint: Req = url(seasonIndexEndpoint.format(BattleNet.getAccessToken))
  val data: Future[String] = http(endpoint OK as.String)
  val json: JValue = parse(data())
  val current_season: Int = (json \ "current_season").extract[Int]
  val service_current_season: Int = (json \ "service_current_season").extract[Int]
  val seasons: List[Season] = (json \ "season").extract[List[Season]]

  def seasonActive: Boolean = {
    if ((json \ "service_season_state").extract[String] == "active") true else false
  }
}
