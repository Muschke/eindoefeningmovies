package be.vdab.eindoefeningmovies.forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class vindNaamAdhvLettersForm {
    @NotEmpty @NotBlank @NotNull private final String letters;

    public vindNaamAdhvLettersForm(String letters) {
        this.letters = letters;
    }

    public String getLetters() {
        return letters;
    }
}
