package be.vdab.eindoefeningmovies.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Genre {
    private final long id;
    @NotNull @NotBlank @NotEmpty private final String genreNaam;

    public Genre(long id, String genreNaam) {
        this.id = id;
        this.genreNaam = genreNaam;
    }

    public long getId() {
        return id;
    }

    public String getGenreNaam() {
        return genreNaam;
    }
}
