package com.github.scarman.battlenet.d3.leaderboards

object Implicits {

  implicit def playerOrdering: Ordering[Player] = Ordering.fromLessThan(_.paragon.getOrElse("0").toInt < _.paragon.getOrElse("0").toInt)
}
