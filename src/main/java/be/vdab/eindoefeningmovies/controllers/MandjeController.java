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
import java.util.Optional;

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
        var modelAndView = new ModelAndView("mandje", "filmsInMandje", filmService.findByIds(mandje.getIds()));
        /*Onderstaand is voor totaal tabel, geeft SQL syntax voorlopig, pas pas in als test werkt*/
        // modelAndView.addObject("totaalMandje", filmService.vindTotalePrijsByIds(mandje.getIds()));
        return modelAndView;
    }

    @PostMapping("verwijderen")
    public String verwijderFilm(long id) {
        mandje.verwijderFilm(id);
        return "redirect:/mandje";
    }
}
