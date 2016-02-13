package com.github.scarman.battlenet.d3.leaderboards

object Boards {

  implicit def boardToString(board: Board): String = board.toString

  sealed abstract class Board(val description: String,
                              val leaderboard: String) {
    override def toString = leaderboard
  }

  case object SOLO_BARB extends Board("Solo Barbarian", "rift-barbarian")

  case object SOLO_CRUSADER extends Board("Solo Crusader", "rift-crusader")

  case object SOLO_DH extends Board("Solo Demon Hunter", "rift-dh")

  case object SOLO_MONK extends Board("Solo Monk", "rift-monk")

  case object SOLO_WD extends Board("Solo Witch Docta", "rift-wd")

  case object SOLO_WIZARD extends Board("Solo Energy Twister", "rift-wizard")

  case object TWO_PLAYER extends Board("2 Player Group", "rift-team-2")

  case object THREE_PLAYER extends Board("3 Player Group", "rift-team-3")

  case object FOUR_PLAYER extends Board("Energy Twister Hoooooooooo!", "rift-team-4")

}
