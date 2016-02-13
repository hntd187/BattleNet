package com.github.scarman

import dispatch.Http
import org.json4s.DefaultFormats

package object battlenet {

  implicit val formats: DefaultFormats = DefaultFormats

  val http: Http = dispatch.Http
  var region: String = "us"
  val authUri: String = f"https://$region.battle.net/oauth/authorize"
  val tokenUri: String = f"https://$region.battle.net/oauth/token"
  val seasonIndexEndpoint: String = f"https://$region.api.battle.net/data/d3/season/?access_token=%%s"
  val seasonLeaderboardEndpoint: String = f"https://$region.api.battle.net/data/d3/season/%%s/leaderboard/%%s?access_token=%%s"
  val eraIndexEndpoint: String = f"https://$region.api.battle.net/data/d3/era/?access_token=%%s"
  val eraLeaderboardEndpoint: String = f"https://$region.api.battle.net/data/d3/era/%%s/leaderboard/%%s?access_token=%%s"


}
