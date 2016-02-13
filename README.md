# BattleNet

A  Scala Interface for the Battle.net API.

Currently supports the Diablo 3 leaderboards, but hopefully adding more.

Requirements
--------
Scala 2.10 or 2.11 (Java6 / Java7)

Battle.Net developer account, [here](https://dev.battle.net).

Battle.Net OAuth Key, explained [here](https://dev.battle.net/docs/read/oauth).

Obtaining
--------
You can get this through the jCenter bintray repo for 2.10 and 2.11 versions of Scala.

```scala
resolvers += Resolver.jcenterRepo
libraryDependencies += "com.github.scarman" %% "battlenet" % "0.1"
```

Please note if it isn't in this repo, I'm probably working on uploading it still, it'll be there soon.

Features
--------
1. Easy to use interface for accessing leaderboards.
2. Lazy loading and requests, so you don't make a request every time you load.
3. Ability to sort player groups and individual players by Rank and Paragon, also (==, <, > != implemented)
4. Some aggregate functions implemented (Highest/Lowest Paragon)
5. Some aliases for common keys and information for ease of access
6. Some level of safe access via wrapping of return data in Option classes and use of Case Classes to define the data

Problems
--------
Currently the way the leaderboards are returned are a player is only returned with their highest rank, so for instance if a group
of player A and B complete a level 10 rift and then players B and C complete a level 15 rift, player B will be displayed in the
level 15, but not in the level 10 team, this is what leads to single person teams on group rift leaderboards. This can also lead
to some "ghost" teams in the results where all players in the group have a higher place in the leaderboards making it hard and expensive
to figure out where that group actually sits.

I have not tried or tested the achievments or conquest leaderboards, they _probably_ work, but no promises. If there is any issues
with that it'd be easy to fix and it's first on my list.

Any found problems please open a github issue or report to me at [shcarman@gmail.com](mailto:shcarman@gmail.com)

Examples
-------
```scala
// Get the Solo Barbarian Leaderboard
import com.github.scarman.battlenet.d3.leaderboards._

SeasonLeaderboard(Boards.SOLO_BARB).getPlayers.foreach{ p =>
  val paddedRank: String = p.rank.getOrElse("").padTo(4, " ").mkString
  println(f"#$paddedRank ${p.riftLevel.get}: ${p.player.head.battleTag.get} (${p.player.head.paragon.get})")
}

/*
#1    88: Chainer#1635 (1736)
#2    85: WiIIis#1180 (1339)
#3    85: Retrolution#6334 (1491)
#4    85: Startawar#1868 (1360)
#5    84: Retep#1958 (1578)
#6    84: fallinwmc#1434 (1229)
#7    84: FriskyDingo#1470 (1255)
#8    83: Cornbread#1325 (1128)
#9    82: Hozz#1331 (1363)
#10   82: FirstSnow#1532 (1074)
*/
```

```scala
// Get the highest paragon's battle tag
import com.github.scarman.battlenet.d3.leaderboards._

val lb: SeasonLeaderboard = SeasonLeaderboard(Boards.SOLO_BARB)
println(f"Highest Paragon(${lb.highestParagon.paragon.get}): ${lb.highestParagon.battleTag.get}")

/*
Highest Paragon(1756): Sixgod#1426
*/
```

Plans for new functionality
-------
I created this library with the idea of collecting and doing easy statistics across some of the Diablo 3 leaderboards, but
implementing some additional functionality to allow people to access other areas of the battle.net api in a similar way is something
I'd like to do given the seemingly non-existent nature of good JVM based libraries for the Battle.Net API (at least from a very cursory search)

So with that in mind my current list for functionality goals
1. Achievement and Conquest Leaderboards
2. The remaining D3 Apis (Items, Followers, Characters)
3. The Starcraft Api
4. The WoW Api

The reason I choose the WoW Api last is because I don't play WoW anymore and there already seem to be a lot of good libraries out there for accessing
that part of the API, so in an effort to reinvent the wheel last, I'll put that aside, but if I get some good feedback about it and a lot of people like my kind
of data access pattern I'll do things as requested and as always if anyone wants to help that'd be fantastic.

Credits
-------
Stephen Carman [<shcarman@gmail.com>](mailto:shcarman@gmail.com)

License
-------
This is created under the MIT License so go nuts with it.

The MIT License (MIT)
Copyright (c) 2016 Stephen Carman <shcarman@gmail.com>

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.