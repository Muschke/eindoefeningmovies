package be.vdab.eindoefeningmovies.domain;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class Film {
    private final long id;
    @NotNull @NotBlank @NotEmpty private final long genreId;
    @NotNull @NotBlank @NotEmpty private final String titel;
    @NotNull @PositiveOrZero private final int voorraad;
    private final int gereserveerd;
    @NotNull @Positive @NumberFormat(pattern = "0.00") private final BigDecimal prijs;
    private boolean beschikbaar = false;
    private final int beschikbareFilms;


    public Film(long id, long genreId, String titel, int voorraad, int gereserveerd, BigDecimal prijs) {
        this.id = id;
        this.genreId = genreId;
        this.titel = titel;
        this.voorraad = voorraad;
        this.gereserveerd = gereserveerd;
        this.prijs = prijs;
        if(voorraadbeschikbaar(this.voorraad, this.gereserveerd)){
            beschikbaar = true;
        }
        this.beschikbareFilms = voorraad - gereserveerd;
    }

    public long getId() {
        return id;
    }

    public long getGenreId() {
        return genreId;
    }

    public String getTitel() {
        return titel;
    }

    public int getVoorraad() {
        return voorraad;
    }

    public int getGereserveerd() {
        return gereserveerd;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public boolean isBeschikbaar() {
        return beschikbaar;
    }

    public int getBeschikbareFilms() {
        return beschikbareFilms;
    }

    private boolean voorraadbeschikbaar(int voorraad, int gereserveerd) {
        boolean beschikbaar = false;
        var actievevoorraad = voorraad - gereserveerd;
        if(actievevoorraad > 0) {
            beschikbaar = true;
        }
        return beschikbaar;
    }
}
