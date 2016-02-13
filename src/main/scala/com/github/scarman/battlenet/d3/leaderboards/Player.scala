package com.github.scarman.battlenet.d3.leaderboards

case class Player(key: Option[String], accountId: Option[String], data: List[Data]) extends Ordered[Player] {

  def battleTag: Option[String] = {
    findData("HeroBattleTag").get.string
  }

  def gameAccount: Option[String] = {
    findData("GameAccount").get.number
  }

  private def findData(key: String): Option[Data] = {
    data.find(d => d.id == key) match {
      case Some(x) => Option(x)
      case None => Option(Data(key, None, None, None))
    }
  }

  def heroClass: Option[String] = {
    findData("HeroClass").get.string
  }

  def level: Option[String] = {
    findData("HeroLevel").get.number
  }

  def clanTag: Option[String] = {
    findData("HeroClanTag").get.string
  }

  def clanName: Option[String] = {
    findData("ClanName").get.string
  }

  def id: Option[String] = {
    findData("id").get.number
  }

  def compare(that: Player): Int = {
    if (this.paragon.getOrElse("0").toInt == that.paragon.getOrElse("0").toInt) {
      0
    } else if (this.paragon.getOrElse("0").toInt > that.paragon.getOrElse("0").toInt) {
      1
    } else {
      -1
    }
  }

  def paragon: Option[String] = {
    findData("ParagonLevel").get.number
  }

}