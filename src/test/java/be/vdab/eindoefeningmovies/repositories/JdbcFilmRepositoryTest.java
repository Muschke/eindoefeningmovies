package be.vdab.eindoefeningmovies.repositories;

import be.vdab.eindoefeningmovies.DTO.FilmsPerGenre;
import be.vdab.eindoefeningmovies.domain.Film;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@JdbcTest
@Import(JdbcFilmRepository.class)
@Sql("/insertFilm.sql")
class JdbcFilmRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private static final String FILMS = "films";
    private final JdbcFilmRepository filmRepository;

    JdbcFilmRepositoryTest(JdbcFilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Test
    void findAllPerGenre() {
        assertThat(filmRepository.findAllPerGenre(8L))
                .hasSize(super.countRowsInTableWhere(FILMS, "genreId = 8"))
                .allSatisfy(filmsPerGenre -> assertThat(filmsPerGenre.getGenreId()).isEqualByComparingTo(8L))
                .extracting(FilmsPerGenre::getGenreId);
    }

    @Test
    void findByid() {
        assertThat(filmRepository.findById(idVanTestFilm()))
                .hasValueSatisfying(film -> assertThat(film.getTitel()).isEqualTo("testFilm"));
    }

    @Test
    void findByIds() {
        long idEen = idVanTestFilm();
        long idTwee = idVanTestFilmTwee();
        assertThat(filmRepository.findByIds(Set.of(idTwee, idEen)))
                .extracting(Film::getId)
                .containsOnly(idEen, idTwee)
                .isSorted();
    }
    @Test
    void findtotaleprijsbyids() {
        long idEen = idVanTestFilm();
        long idTwee = idVanTestFilmTwee();
        assertThat(filmRepository.vindTotalePrijsByIds(Set.of(idTwee, idEen))).isEqualByComparingTo(BigDecimal.TEN);
    }

    @Test
    void legeVerzamelingGeeftLegeSet() {
        assertThat(filmRepository.findByIds(Set.of())).isEmpty();
    }
    @Test
    void geeftLegeSetAlsOnbestaande() {
        assertThat(filmRepository.findByIds(Set.of(-7L, -8L))).isEmpty();
    }

    @Test
    void update(){
        var id = idVanTestFilm();
        filmRepository.update(id);
        assertThat(filmRepository.findById(id))
                .hasValueSatisfying(film -> assertThat(film.getGereserveerd()).isOne());
    }
    private long idVanTestFilm() {
        return jdbcTemplate.queryForObject("select id from films where titel = 'testFilm'", long.class);
    }
    private long idVanTestFilmTwee() {
        return jdbcTemplate.queryForObject("select id from films where titel = 'testFilmTwee'", long.class);
    }

}