package com.github.scarman.battlenet
package d3.leaderboards

/**
  * Created by scarman on 2/11/16.
  */
object LeaderboardTests extends App {

  BattleNet.withAccessToken("")

  // Era and Seasonal have the same interface so you can use them in the exact same
  // way and you should get similar results.

  val lb: SeasonLeaderboard = SeasonLeaderboard(Boards.SOLO_BARB)
  val elb: EraLeaderboard = EraLeaderboard(Boards.SOLO_BARB)

  val minParagon: Player = lb.lowestParagon
  val maxParagon: Player = lb.highestParagon

  lb.getPlayers.foreach { p =>

    // Remember even for solo leaderboards it returns a list of players. It's just
    // the way the JSON comes back.

    val paddedRank: String = p.rank.getOrElse("").padTo(4, " ").mkString
    println(f"#$paddedRank ${p.riftLevel.get}: ${p.player.head.battleTag.get} (${p.player.head.paragon.get})")
    if (p.player.length > 1) {
      var i = 1
      while (i < p.player.length) {
        println(f"      ${p.riftLevel.get}: ${p.player(i).battleTag.get} (${p.player(i).paragon.get})")
        i += 1
      }
    }
  }

  println
  println(f"Max paragon(${maxParagon.paragon.get}): ${maxParagon.battleTag.get}")
  println(f"Lowest paragon(${minParagon.paragon.get}): ${minParagon.battleTag.get}")

  http.shutdown()

}
