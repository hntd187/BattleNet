package com.github.scarman.battlenet
package d3.leaderboards

import dispatch.{Req, url}

class EraLeaderboard(private val board: String, private val era: Int = EraIndex.current_era) extends Leaderboard {
  override protected val lb: Req = url(eraLeaderboardEndpoint.format(era, board, BattleNet.getAccessToken))
}

object EraLeaderboard {
  def apply(board: String): EraLeaderboard = {
    new EraLeaderboard(board)
  }
}