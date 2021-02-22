package hu.kirdev.demo.converter

import hu.kirdev.demo.model.Movie
import hu.kirdev.demo.model.MovieEntity
import org.springframework.stereotype.Component

@Component
open class MovieToMovieEntity {

    fun convert (movie: Movie): MovieEntity {

        return MovieEntity(
                movieTitle = movie.title,
                movieGenre = movie.genre,
                movieReleaseYear = movie.releaseYear,
                movieReviewScore = movie.reviewScore
        )

    }

}