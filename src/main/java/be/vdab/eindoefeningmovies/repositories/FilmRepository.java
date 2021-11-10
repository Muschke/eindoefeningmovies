package be.vdab.eindoefeningmovies.repositories;

import be.vdab.eindoefeningmovies.DTO.FilmsPerGenre;
import be.vdab.eindoefeningmovies.domain.Film;

import java.util.List;
import java.util.Optional;

public interface FilmRepository {
    List<FilmsPerGenre> findAllPerGenre(long id);
    Optional<Film> findById(long id);
}
