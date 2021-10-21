package com.pk.domain

sealed trait Symbol {
    protected  def beats: List[Symbol]
    def wins(other: Symbol) = beats.contains(other)
}

case object Rock extends Symbol{
    protected val beats = List(Scissor, Lizard)
}

case object Paper extends Symbol{
    protected val beats = List(Rock, Spock)
}

case object Scissor extends Symbol{
    protected val beats = List(Paper, Lizard)
}

case object Lizard extends Symbol{
    protected val beats = List(Spock, Paper)
}

case object Spock extends Symbol{
    protected val beats = List(Scissor, Rock)
}

object Symbol {
    def apply(str: String): Symbol = 
        str.trim.toLowerCase match {
            case "paper" => Paper
            case "lizard" => Lizard
            case "scissor" => Scissor
            case "rock" => Rock
            case "spock" => Spock
            case unknown => throw new IllegalArgumentException(s"Unknown symbol - $unknown")
        }
}