package com.github.scarman.battlenet.d3.leaderboards

import org.scalatest.FunSuite

/**
  * Created by hntd on 2/12/2016.
  */
class PlayerTests extends FunSuite {

  def data(k: String, n: String): List[Data] = {
    List[Data](Data(k, Some(n), None, None))
  }

  test("Player Comparison") {
    val player1 = Player(None, Some("1"), data("ParagonLevel", "10"))
    val player2 = Player(None, Some("2"), data("ParagonLevel", "5"))
    val player3 = player2
    val player4 = Player(None, Some("4"), data("ParagonLevel", "5"))

    assert(player1 > player2)
    assert(player2 < player1)
    assert(player3 == player2)
    assert(player4 != player2)

  }

  test("Group Comparison") {
    val player1 = Player(None, Some("1"), List[Data](Data("ParagonLevel", Some("10"), None, None)))
    val player2 = Player(None, Some("2"), List[Data](Data("ParagonLevel", Some("5"), None, None)))
    val playerList = List[Player](player1, player2)

    val group1 = Players(playerList, 1, data("Rank", "5"))
    val group2 = Players(playerList, 1, data("Rank", "10"))
    val group3 = group2

    assert(group1 < group2)
    assert(group2 > group1)
    assert(group2 == group3)
    assert(group1 != group2)

  }

}
