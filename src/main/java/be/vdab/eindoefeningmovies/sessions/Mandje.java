package be.vdab.eindoefeningmovies.sessions;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Component
@SessionScope
public class Mandje implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Set<Long> ids = new LinkedHashSet<>();

    public void voegFilmToe(long id) {
        ids.add(id);
    }
    public void verwijderFilm(long id) {ids.remove(id);}
    public Set<Long> getIds() {
        return ids;
    }
    public int telAantalFilms() {
        var aantal = ids.size();
        return aantal;
    }
}
