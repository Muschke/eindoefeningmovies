package be.vdab.eindoefeningmovies.controllers;

import be.vdab.eindoefeningmovies.domain.Reservatie;
import be.vdab.eindoefeningmovies.forms.vindNaamAdhvLettersForm;
import be.vdab.eindoefeningmovies.services.FilmService;
import be.vdab.eindoefeningmovies.services.KlantService;
import be.vdab.eindoefeningmovies.services.ReservatieService;
import be.vdab.eindoefeningmovies.sessions.Mandje;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@RequestMapping("klanten")
class KlantController {
    private final KlantService klantService;
    private final FilmService filmService;
    private final ReservatieService reservatieService;
    private final Mandje mandje;

    KlantController(KlantService klantService, FilmService filmService, ReservatieService reservatieService, Mandje mandje) {
        this.klantService = klantService;
        this.filmService = filmService;
        this.reservatieService = reservatieService;
        this.mandje = mandje;
    }


    //form in de pagina steken
    @GetMapping("/form")
    public ModelAndView findByStartlettersForm() {
      return new ModelAndView("klanten").addObject(new vindNaamAdhvLettersForm(null));
    }

    //form verwerken ! geen post gebruiken
    @GetMapping
    public ModelAndView findByStartletters(vindNaamAdhvLettersForm form, Errors errors) {
        var modelAndview = new ModelAndView("klanten");
        if(errors.hasErrors()){
            return modelAndview;
        }
        return modelAndview.addObject("klantenMetStartletters", klantService.findByBevatLetters(form.getLetters()));
    }

    @GetMapping("/bevestigen/{id}")
    public ModelAndView findByIdKlant(@PathVariable long id) {
        var modelAndView = new ModelAndView("bevestigen");
        klantService.findById(id)
                .ifPresent(klant -> {
                    modelAndView.addObject("klant", klant);
                });
        modelAndView.addObject("filmsInMandje", mandje.telAantalFilms());
        modelAndView.addObject("filmIds", mandje.getIds());
        return modelAndView;
    }
    @GetMapping("/bevestigen/{id}/form")
    public ModelAndView toevoegenReservatie(){
        return new ModelAndView("bevestigen").addObject(new Reservatie(0, 0, LocalDateTime.now()));
    }

    @PostMapping("/bevestigen/verwerken")
        public String toevoegenEnUpdaten(@Valid Reservatie reservatie, Errors errors) {
       /* if(errors.hasErrors()){
            return "/klanten/bevestigen/{id}";
        }*/
        reservatieService.updateAndCreate(reservatie);
        return "redirect:/rapport";
    }
}
