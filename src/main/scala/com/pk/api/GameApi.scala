package com.pk.api

import cats.effect.IO
import com.pk.domain.Game
import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl

class GamesApi extends Http4sDsl[IO] {
    val routes = HttpRoutes.of[IO] {
        case req @ POST -> Root / "play" => 
            for {
                text <- req.as[String]
                response <- Ok(Game(text).result)
            } yield response
    }
}