package hu.kirdev.demo.service

import hu.kirdev.demo.`interface`.MovieGenre
import hu.kirdev.demo.`interface`.MovieService
import hu.kirdev.demo.converter.MovieEntityToMovie
import hu.kirdev.demo.converter.MovieToMovieEntity
import hu.kirdev.demo.model.Movie
import hu.kirdev.demo.model.MovieEntity
import hu.kirdev.demo.repository.MovieRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.util.*
import javax.annotation.PostConstruct

@Service
class MovieServiceImpl: MovieService {

    @Autowired
    lateinit var movieRepository: MovieRepository

    @Autowired
    lateinit var movieEntityToMovie: MovieEntityToMovie

    @Autowired
    lateinit var movieToMovieEntity: MovieToMovieEntity

    override fun getAllMovies(): List<Movie> {
        return movieRepository.findAll().map { movieEntity -> movieEntityToMovie.convert(movieEntity) }
    }

    override fun addMovie(movie: Movie) {
        movieRepository.save( movieToMovieEntity.convert(movie) )
    }

    override fun initMovies() {

        // TODO

    }

    override fun clearMovies() {
        movieRepository.deleteAll()
    }

}