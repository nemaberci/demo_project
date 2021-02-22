package hu.kirdev.demo.model

import hu.kirdev.demo.`interface`.MovieGenre

data class Movie (
        var title: String,
        var releaseYear: Int,
        var reviewScore: Int,
        var genre: String,
        var ID: Long = 0
) {



}