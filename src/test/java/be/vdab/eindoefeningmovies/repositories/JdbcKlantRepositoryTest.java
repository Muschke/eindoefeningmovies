package be.vdab.eindoefeningmovies.repositories;

import be.vdab.eindoefeningmovies.domain.Klant;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;


@JdbcTest
@Import(JdbcKlantRepository.class)
@Sql("/insertKlant.sql")
class JdbcKlantRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private static final String KLANTEN = "klanten";
    private final JdbcKlantRepository klantRepository;

    JdbcKlantRepositoryTest(JdbcKlantRepository klantRepository) {
        this.klantRepository = klantRepository;
    }

    @Test
    void findByStartletters() {
        assertThat(klantRepository.findByBevatLetters("k"))
                .hasSize(countRowsInTableWhere(KLANTEN, "familienaam like 'k%'"))
                .extracting(Klant::getFamilienaam)
                .allSatisfy(naam -> assertThat(naam.toLowerCase(Locale.ROOT)).startsWith("k"))
                .isSortedAccordingTo(String::compareToIgnoreCase);
    }
}