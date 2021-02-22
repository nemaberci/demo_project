package hu.kirdev.demo.`interface`

import hu.kirdev.demo.model.Movie

interface MovieService {

    fun getAllMovies(): List<Movie>

    fun addMovie(movie: Movie)

    fun initMovies()

    fun clearMovies()

}