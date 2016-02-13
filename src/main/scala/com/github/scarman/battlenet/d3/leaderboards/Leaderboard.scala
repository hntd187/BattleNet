package com.github.scarman.battlenet
package d3.leaderboards

import dispatch.Defaults._
import dispatch._
import org.json4s._
import org.json4s.native.JsonMethods._

import scala.collection.SortedSet

abstract class Leaderboard {

  protected val lb: Req
  private var players: Option[SortedSet[Players]] = None: Option[SortedSet[Players]]

  def highestParagon: Player = {
    if (players.isEmpty) getPlayers
    players.get.maxBy(p => p.player.max).player.max
  }

  def getPlayers: SortedSet[Players] = this.getPlayers(false)

  def getPlayers(force: Boolean): SortedSet[Players] = {
    if (players.nonEmpty && !force) {
      return players.get
    }
    val data: Future[String] = http(lb OK as.String)
    val json: JValue = parse(data())
    players = Some(SortedSet[Players]() ++ (json \ "row").extract[Set[Players]])
    players.get
  }

  def lowestParagon: Player = {
    if (players.isEmpty) getPlayers
    players.get.minBy(p => p.player.min).player.min
  }

}
