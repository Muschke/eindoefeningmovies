package be.vdab.eindoefeningmovies.controllers;

import be.vdab.eindoefeningmovies.forms.vindNaamAdhvLettersForm;
import be.vdab.eindoefeningmovies.services.KlantService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("klanten")
class KlantController {
    private final KlantService klantService;

    KlantController(KlantService klantService) {
        this.klantService = klantService;
    }

    //form in de pagina steken
    @GetMapping
    public ModelAndView findByStartlettersForm() {
      return new ModelAndView("klanten").addObject(new vindNaamAdhvLettersForm(null));
    }

    //form verwerken ! geen post gebruiken
    @GetMapping("klanten")
    public ModelAndView findByStartletters(vindNaamAdhvLettersForm form) {
        return new ModelAndView("klanten", "klantenMetStartletters", klantService.findByBevatLetters(form.getLetters()));
    }


}
