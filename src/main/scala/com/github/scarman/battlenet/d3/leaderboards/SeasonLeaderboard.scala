package com.github.scarman.battlenet
package d3.leaderboards

import dispatch.Defaults._
import dispatch._
import org.json4s._
import org.json4s.native.JsonMethods._

import scala.collection.SortedSet

class SeasonLeaderboard(private val board: String) {

  private val lb: Req = url(leaderBoardEndpoint.format(SeasonIndex.current_season, board, BattleNet.getAccessToken))

  private var players: Option[SortedSet[Players]] = None: Option[SortedSet[Players]]

  def getPlayers: SortedSet[Players] = this.getPlayers(false)

  def getPlayers(force: Boolean): SortedSet[Players] = {
    if (players.nonEmpty && !force) {
      return players.get
    }
    val data: Future[String] = Http(lb OK as.String)
    val json: JValue = parse(data())
    players = Some(SortedSet[Players]() ++ (json \ "row").extract[Set[Players]])
    players.get
  }

  def highestParagon: Player = {
    if (players.isEmpty) getPlayers
    players.get.maxBy(p => p.player.max).player.max
  }

  def lowestParagon: Player = {
    if (players.isEmpty) getPlayers
    players.get.minBy(p => p.player.min).player.min
  }

}

object SeasonLeaderboard extends App {

  def apply(board: String): SeasonLeaderboard = {
    new SeasonLeaderboard(board)
  }

  BattleNet.withAccessToken("")

  val lb: SeasonLeaderboard = SeasonLeaderboard("rift-wizard")

  lb.getPlayers.foreach { p =>
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
  val maxParagon: Player = lb.highestParagon
  val minParagon: Player = lb.lowestParagon
  println(f"Max paragon(${maxParagon.paragon.get}): ${maxParagon.battleTag.get}")
  println(f"Lowest paragon(${minParagon.paragon.get}): ${minParagon.battleTag.get}")
  scala.sys.exit()
}
