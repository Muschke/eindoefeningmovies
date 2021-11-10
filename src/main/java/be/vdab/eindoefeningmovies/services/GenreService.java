package be.vdab.eindoefeningmovies.services;

import be.vdab.eindoefeningmovies.domain.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> findAll();
}
