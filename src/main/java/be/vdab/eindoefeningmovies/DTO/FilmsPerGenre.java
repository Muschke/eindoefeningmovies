package be.vdab.eindoefeningmovies.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class FilmsPerGenre {
    private final long id;
    @NotNull @NotBlank @NotEmpty private final long genreId;

    public FilmsPerGenre(long id, long genreId) {
        this.id = id;
        this.genreId = genreId;
    }

    public long getId() {
        return id;
    }

    public long getGenreId() {
        return genreId;
    }
}
