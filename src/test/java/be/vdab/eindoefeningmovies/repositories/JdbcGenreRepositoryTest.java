package be.vdab.eindoefeningmovies.repositories;

import be.vdab.eindoefeningmovies.domain.Genre;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
@Import(JdbcGenreRepository.class)
@Sql({"/insertGenre.sql"})
class JdbcGenreRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    private static final String GENRES = "genres";
    private final JdbcGenreRepository genreRepository;

    JdbcGenreRepositoryTest(JdbcGenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Test
    void findAll() {
        assertThat(genreRepository.findAll())
                .hasSize(countRowsInTable(GENRES))
                .extracting(Genre::getGenreNaam)
                .isSorted();
    }
}