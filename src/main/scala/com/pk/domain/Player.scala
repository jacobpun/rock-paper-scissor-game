package com.pk.domain

class Player(name:String, val symbol: Symbol) {
    override def toString(): String = s"$name: $symbol"
}

object Player {
    def apply(nameAndSymbol: String): Player = 
        nameAndSymbol.split(":", 2) match {
            case Array(name, symbol) => new Player(name, Symbol(symbol.trim()))
            case _ => throw new IllegalArgumentException(s"$nameAndSymbol cannot be de-serialized to a Player object")
        }
    

    def unapply(player: Player): Option[Symbol] = Option(player.symbol)
}