package be.vdab.eindoefeningmovies.repositories;


import be.vdab.eindoefeningmovies.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreRepository {
    List<Genre> findAll();
}
