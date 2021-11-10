package be.vdab.eindoefeningmovies.controllers;

import be.vdab.eindoefeningmovies.services.FilmService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("films")
class FilmController {
    private final FilmService filmService;

    FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("{id}")
    public ModelAndView film (@PathVariable long id) {
        var modelAndView = new ModelAndView("film");
        filmService.findById(id)
                .ifPresent(film -> {
                    modelAndView.addObject("film", film);
                });
        return modelAndView;
    }

}
