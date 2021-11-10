package be.vdab.eindoefeningmovies.services;
import be.vdab.eindoefeningmovies.DTO.FilmsPerGenre;
import be.vdab.eindoefeningmovies.domain.Film;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface FilmService {
    List<FilmsPerGenre> findAllPerGenre(long id);
    Optional<Film> findById(long id);
    List<Film> findByIds(Set<Long> ids);
}
