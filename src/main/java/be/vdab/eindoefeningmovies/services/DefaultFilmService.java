package be.vdab.eindoefeningmovies.services;

import be.vdab.eindoefeningmovies.DTO.FilmsPerGenre;
import be.vdab.eindoefeningmovies.domain.Film;
import be.vdab.eindoefeningmovies.repositories.FilmRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
}
