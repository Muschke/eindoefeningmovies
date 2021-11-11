package be.vdab.eindoefeningmovies.repositories;

import be.vdab.eindoefeningmovies.domain.Film;
import be.vdab.eindoefeningmovies.domain.Klant;

import java.util.List;
import java.util.Optional;

public interface KlantRepository {
    List<Klant> findByBevatLetters(String startletters);
    Optional<Klant> findById(long id);
}
