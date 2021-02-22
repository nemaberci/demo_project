package hu.kirdev.demo.controller

import hu.kirdev.demo.`interface`.MovieService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexController {

    @Autowired
    lateinit var movieService: MovieService

    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute("movies", movieService.getAllMovies())
        return "index"
    }

}