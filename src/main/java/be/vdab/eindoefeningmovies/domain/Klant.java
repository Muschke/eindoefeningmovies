package be.vdab.eindoefeningmovies.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Klant {
    private final long id;
    @NotNull @NotBlank @NotEmpty private final String familienaam;
    @NotNull @NotBlank @NotEmpty private final String voornaam;
    @NotNull @NotBlank @NotEmpty private final String straatNummer;
    @NotNull @NotBlank @NotEmpty private final int postcode;
    @NotNull @NotBlank @NotEmpty private final String gemeente;

    public Klant(long id, String familienaam, String voornaam, String straatNummer, int postcode, String gemeente) {
        this.id = id;
        this.familienaam = familienaam;
        this.voornaam = voornaam;
        this.straatNummer = straatNummer;
        this.postcode = postcode;
        this.gemeente = gemeente;
    }

    public long getId() {
        return id;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getStraatNummer() {
        return straatNummer;
    }

    public int getPostcode() {
        return postcode;
    }

    public String getGemeente() {
        return gemeente;
    }
}
