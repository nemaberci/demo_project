package hu.kirdev.demo.model

import hu.kirdev.demo.`interface`.MovieGenre
import javax.persistence.Entity
import javax.persistence.GeneratedValue

@Entity
class MovieEntity (var movieTitle: String = "", var movieReleaseYear: Int = 0, var movieReviewScore: Int = 0, var movieGenre: MovieGenre = MovieGenre.ACTION) {

    @javax.persistence.Id
    @GeneratedValue
    var ID: Long = 0

    var title: String = movieTitle

    var releaseYear: Int = movieReleaseYear

    var reviewScore: Int = movieReviewScore

    var genre: MovieGenre = movieGenre

}