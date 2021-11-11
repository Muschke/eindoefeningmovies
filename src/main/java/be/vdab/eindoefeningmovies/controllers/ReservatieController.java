package be.vdab.eindoefeningmovies.controllers;

import be.vdab.eindoefeningmovies.services.ReservatieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("rapport")
class ReservatieController {
    private final ReservatieService reservatieService;

    ReservatieController(ReservatieService reservatieService) {
        this.reservatieService = reservatieService;
    }
}
