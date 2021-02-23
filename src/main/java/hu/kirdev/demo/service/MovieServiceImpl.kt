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

    @PostConstruct
    override fun initMovies() {

        if (movieRepository.count() > 0) {

            println("System already has ${movieRepository.count()} elements.")

            return
        }

        try {

            Files.readAllLines(Path.of("src/main/resources/movies.csv"))
                    .drop(1)
                    .map {
                        line -> line.split(',')
                    }
                    .map {
                        data ->
                            movieRepository.save(
                                    MovieEntity(
                                            movieTitle = data[0],
                                            movieGenre = when (data[1]) {
                                                "Action" -> MovieGenre.ACTION
                                                "Animation" -> MovieGenre.ANIMATION
                                                "Comedy" -> MovieGenre.COMEDY
                                                "Drama" -> MovieGenre.DRAMA
                                                "Fantasy" -> MovieGenre.FANTASY
                                                "Romance" -> MovieGenre.ROMANCE
                                                else -> MovieGenre.ACTION
                                            }, // MovieGenre.valueOf(data[1].toUpperCase())
                                            movieReviewScore = data[2].toInt(),
                                            movieReleaseYear = data[3].toInt()
                                    )
                            )
                    }

        } catch (ex: Exception) {

            ex.printStackTrace()

        }

        println("Added ${movieRepository.count()} elements.")

    }

    override fun clearMovies() {
        movieRepository.deleteAll()
    }

}