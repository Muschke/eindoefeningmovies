package be.vdab.eindoefeningmovies.services;

import be.vdab.eindoefeningmovies.domain.Klant;

import java.util.List;
import java.util.Optional;

public interface KlantService {
    List<Klant> findByBevatLetters(String startletters);
    Optional<Klant> findById(long id);
}
