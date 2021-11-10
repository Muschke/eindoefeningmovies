package be.vdab.eindoefeningmovies.sessions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MandjeTest {
    private Mandje mandje;
    @BeforeEach
    void beforeEach() {
        mandje = new Mandje();
    }
    @Test
    @DisplayName("een nieuw mandje is leeg")
    void eenNieuwMandjeIsLeeg() {
        assertThat(mandje.getIds()).isEmpty();
    }

    @Test
    @DisplayName("na toevoegen van 1 ID bevat mandje dat ID")
    void naToevoegenVan1IdBevatMandjeDatId() {
        mandje.voegFilmToe(10L);
        assertThat(mandje.getIds()).containsOnly(10L);
    }
    @Test
    @DisplayName("je kan een item maar eén keer toevoegen aan het mandje")
    void jeKanEenItemMaarÉénKeerToevoegenAanHetMandje() {
        mandje.voegFilmToe(10L);
        mandje.voegFilmToe(10L);
        assertThat(mandje.getIds()).containsOnly(10L);
    }
    @Test
    @DisplayName("na toevoegen van 2 Id's bevat mandje die 2 id's")
    void nadatJeTweeItemsInHetMandjeLegtBevatDitMandjeEnkelDieItems() {
        mandje.voegFilmToe(10L);
        mandje.voegFilmToe(20L);
        assertThat(mandje.getIds()).containsOnly(10L, 20L);
    }
}