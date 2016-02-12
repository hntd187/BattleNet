package com.github.scarman.battlenet

object BattleNet {

  private var accessToken: String = ""

  def getAccessToken: String = {
    require(accessToken.nonEmpty)
    accessToken
  }

  def withAccessToken(token: String): Unit = {
    accessToken = token
  }

}
