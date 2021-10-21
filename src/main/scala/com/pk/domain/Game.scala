package com.pk.domain

case class Game(val player1: Player, val player2: Player) {
    def winner(): Option[Player] = 
        (player1, player2) match {
            case (Player(s1), Player(s2)) if s1.wins(s2) => Some(player1)
            case (Player(s1), Player(s2)) if s2.wins(s1) => Some(player2)
            case _ => None
        }

    val result = winner().map(player => s"$player won!").getOrElse("Its a draw!")  + "\r\n"
}

object Game {
    def apply(players: String): Game = 
        players.split("-", 2) match {
            case Array(player1, player2) => Game(Player(player1), Player(player2))
            case _ => throw new IllegalArgumentException(s"$players cannot be parsed to a game")
        }
    
}