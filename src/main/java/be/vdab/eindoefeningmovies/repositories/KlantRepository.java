package be.vdab.eindoefeningmovies.repositories;

import be.vdab.eindoefeningmovies.domain.Klant;

import java.util.List;

public interface KlantRepository {
    List<Klant> findByBevatLetters(String startletters);
}
