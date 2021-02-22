package hu.kirdev.demo.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue

@Entity
class MovieEntity (var movieTitle: String = "", var movieReleaseYear: Int = 0, var movieReviewScore: Int = 0, var movieGenre: String = "") {

    @javax.persistence.Id
    @GeneratedValue
    var ID: Long = 0

    var title: String = movieTitle

    var releaseYear: Int = movieReleaseYear

    var reviewScore: Int = movieReviewScore

    var genre: String = movieGenre

}