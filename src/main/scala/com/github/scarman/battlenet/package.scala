package com.github.scarman

import org.json4s.DefaultFormats

/**
  * Created by scarman on 2/10/16.
  */
package object battlenet {

  implicit val formats: DefaultFormats = DefaultFormats

  var region: String = "us"

  val authUri: String = f"https://$region.battle.net/oauth/authorize"
  val tokenUri: String = f"https://$region.battle.net/oauth/token"

  val seasonIndexEndpoint: String = f"https://$region.api.battle.net/data/d3/season/?access_token=%%s"
  val leaderBoardEndpoint: String = f"https://$region.api.battle.net/data/d3/season/%%s/leaderboard/%%s?access_token=%%s"
}
