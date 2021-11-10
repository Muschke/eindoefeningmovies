package be.vdab.eindoefeningmovies.controllers;

import be.vdab.eindoefeningmovies.services.FilmService;
import be.vdab.eindoefeningmovies.sessions.Mandje;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.Positive;

@Controller
@RequestMapping("mandje")
class MandjeController {
    private final Mandje mandje;
    private final FilmService filmService;

    MandjeController(Mandje mandje, FilmService filmService) {
        this.mandje = mandje;
        this.filmService = filmService;
    }

    @PostMapping("{id}")
    public String voegFilmToe(@PathVariable long id) {
        mandje.voegFilmToe(id);
        return "redirect:/mandje";
    }
    @GetMapping
    public ModelAndView haalMandje() {
        return new ModelAndView("mandje", "filmsInMandje", filmService.findByIds(mandje.getIds()));
    }

    @PostMapping("verwijderen")
    public String verwijderFilm(@PathVariable long id) {
        mandje.verwijderFilm(id);
        return "redirect:/mandje";
    }
}
