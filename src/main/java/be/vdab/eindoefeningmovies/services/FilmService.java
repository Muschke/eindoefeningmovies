package be.vdab.eindoefeningmovies.services;
import be.vdab.eindoefeningmovies.DTO.FilmsPerGenre;
import be.vdab.eindoefeningmovies.domain.Film;

import java.util.List;
import java.util.Optional;

public interface FilmService {
    List<FilmsPerGenre> findAllPerGenre(long id);
}
