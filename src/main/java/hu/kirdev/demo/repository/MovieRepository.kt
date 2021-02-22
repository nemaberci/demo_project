package hu.kirdev.demo.repository

import hu.kirdev.demo.model.MovieEntity
import org.springframework.data.repository.CrudRepository

interface MovieRepository : CrudRepository <MovieEntity, Long> {


}