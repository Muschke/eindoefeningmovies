package be.vdab.eindoefeningmovies.controllers;

import be.vdab.eindoefeningmovies.services.FilmService;
import be.vdab.eindoefeningmovies.services.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

@Controller
@RequestMapping("/")
class IndexController {
    private final GenreService genreService;
    private final FilmService filmService;

    IndexController(GenreService genreService, FilmService filmService) {
        this.genreService = genreService;
        this.filmService = filmService;
    }

    @GetMapping
    public ModelAndView genres() {

        return new ModelAndView("index", "genres", genreService.findAll());
    }

    @GetMapping("{id}")
    public ModelAndView filmsPerGenre(@PathVariable long id) {
        var modelAndView = new ModelAndView("index", "filmsPerGenre", filmService.findAllPerGenre(id));
        modelAndView.addObject("genres", genreService.findAll());
        return modelAndView;
    }

}
