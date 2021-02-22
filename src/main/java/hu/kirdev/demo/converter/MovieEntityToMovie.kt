package hu.kirdev.demo.converter

import hu.kirdev.demo.model.Movie
import hu.kirdev.demo.model.MovieEntity
import org.springframework.stereotype.Component

@Component
open class MovieEntityToMovie {

    fun convert (movieEntity: MovieEntity): Movie {

        return Movie(
                title = movieEntity.title,
                releaseYear = movieEntity.releaseYear,
                reviewScore = movieEntity.reviewScore,
                genre = movieEntity.genre.toString(),
                ID = movieEntity.ID
        )

    }

}