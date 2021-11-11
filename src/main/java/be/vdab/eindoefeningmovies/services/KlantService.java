package be.vdab.eindoefeningmovies.services;

import be.vdab.eindoefeningmovies.domain.Klant;

import java.util.List;

public interface KlantService {
    List<Klant> findByBevatLetters(String startletters);
}
