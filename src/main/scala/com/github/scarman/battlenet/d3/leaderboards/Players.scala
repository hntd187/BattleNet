package com.github.scarman.battlenet.d3.leaderboards

case class Players(player: List[Player], order: Int, data: List[Data]) extends Ordered[Players] {

  private def findData(key: String): Option[Data] = {
    data.find(d => d.id == key) match {
      case Some(x) => Option(x)
      case None => Option(Data(key, None, None, None))
    }
  }

  def getPlayer: Player = {
    player.head
  }

  def rank: Option[String] = {
    findData("Rank").get.number
  }

  def achievementPoints: Option[String] = {
    findData("AchievementPoints").get.number
  }

  def completed: Option[String] = {
    findData("CompletedTime").get.timestamp
  }

  def battleTag: Option[String] = {
    findData("BattleTag").get.string
  }

  def riftLevel: Option[String] = {
    findData("RiftLevel").get.number
  }

  def riftTime: Option[String] = {
    findData("RiftTime").get.timestamp
  }

  def compare(that: Players): Int = {
    if (this.rank.getOrElse(0) == that.rank.getOrElse(0)) {
      0
    } else if (this.rank.getOrElse("1000").toInt > that.rank.getOrElse("1000").toInt) {
      1
    } else {
      -1
    }
  }
}
