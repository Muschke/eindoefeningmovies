package be.vdab.eindoefeningmovies.controllers;

import be.vdab.eindoefeningmovies.services.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("genres")
class GenreController {
    private final GenreService genreService;

    GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public ModelAndView genres() {
        return new ModelAndView("index")
                .addObject("genres", genreService.findAll());
    }
}
