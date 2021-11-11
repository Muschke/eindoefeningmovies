package be.vdab.eindoefeningmovies.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class Reservatie {
    @NotNull @NotBlank @NotEmpty private final long klantid;
    @NotNull @NotBlank @NotEmpty private final long filmId;
    @DateTimeFormat(style = "F-") private final LocalDate date;

    public Reservatie(long klantid, long filmId, LocalDate date) {
        this.klantid = klantid;
        this.filmId = filmId;
        this.date = date;
    }

    public long getKlantid() {
        return klantid;
    }

    public long getFilmId() {
        return filmId;
    }

    public LocalDate getDate() {
        return date;
    }
}
