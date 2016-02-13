package com.github.scarman.battlenet
package d3.leaderboards

import dispatch.{Req, url}

class SeasonLeaderboard(private val board: String, private val season: Int = SeasonIndex.current_season) extends Leaderboard {
  override protected val lb: Req = url(seasonLeaderboardEndpoint.format(season, board, BattleNet.getAccessToken))
}

object SeasonLeaderboard extends App {
  def apply(board: String): SeasonLeaderboard = {
    new SeasonLeaderboard(board)
  }
}
