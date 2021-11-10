package be.vdab.eindoefeningmovies.services;
import be.vdab.eindoefeningmovies.domain.Film;

import java.util.List;
import java.util.Optional;

public interface FilmService {
    List<Film> findAllPerGenre(long id);
}
