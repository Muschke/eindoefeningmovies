package be.vdab.eindoefeningmovies.services;

import be.vdab.eindoefeningmovies.domain.Genre;
import be.vdab.eindoefeningmovies.repositories.GenreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
class DefaultGenreService implements GenreService{
    private final GenreRepository genreRepository;

    public DefaultGenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }
}
