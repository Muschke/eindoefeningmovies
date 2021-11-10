package be.vdab.eindoefeningmovies.services;

import be.vdab.eindoefeningmovies.DTO.FilmsPerGenre;
import be.vdab.eindoefeningmovies.domain.Film;
import be.vdab.eindoefeningmovies.repositories.FilmRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class DefaultFilmService implements  FilmService{
    private final FilmRepository filmRepository;

    public DefaultFilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<FilmsPerGenre> findAllPerGenre(long id) {
        return filmRepository.findAllPerGenre(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Film> findById(long id) {
        return filmRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Film> findByIds(Set<Long> ids) {
        return filmRepository.findByIds(ids);
    }

    @Override
    @Transactional(readOnly = true)
    public BigDecimal vindTotalePrijsByIds(Set<Long> ids) {
        return filmRepository.vindTotalePrijsByIds(ids);
    }
}
