package be.vdab.eindoefeningmovies.repositories;

import be.vdab.eindoefeningmovies.DTO.FilmsPerGenre;
import be.vdab.eindoefeningmovies.domain.Film;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface FilmRepository {
    List<FilmsPerGenre> findAllPerGenre(long id);
    Optional<Film> findById(long id);
    List<Film> findByIds(Set<Long> ids);
    BigDecimal vindTotalePrijsByIds(Set<Long> ids);
    void update(long id);
}
