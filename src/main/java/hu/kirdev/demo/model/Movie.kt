package hu.kirdev.demo.model

data class Movie (
        var title: String,
        var releaseYear: Int,
        var reviewScore: Int,
        var genre: String,
        var ID: Long = 0
) {



}