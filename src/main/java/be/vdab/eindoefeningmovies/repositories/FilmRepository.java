package be.vdab.eindoefeningmovies.repositories;

import be.vdab.eindoefeningmovies.domain.Film;

import java.util.List;
import java.util.Optional;

public interface FilmRepository {
    List<Film> findAllPerGenre(long id);
}
