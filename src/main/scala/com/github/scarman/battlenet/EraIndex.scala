package com.github.scarman.battlenet

import dispatch.Defaults._
import dispatch._
import org.json4s._
import org.json4s.native.JsonMethods._

case class Era(href: String)

object EraIndex {

  val endpoint: Req = url(eraIndexEndpoint.format(BattleNet.getAccessToken))
  val data: Future[String] = http(endpoint OK as.String)
  val json: JValue = parse(data())
  val current_era: Int = (json \ "current_era").extract[Int]
  val eras: List[Era] = (json \ "era").extract[List[Era]]

}