package be.vdab.eindoefeningmovies.repositories;

import be.vdab.eindoefeningmovies.domain.Reservatie;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@JdbcTest
@Import(JdbcReservatieRepository.class)
@Sql("/insertReservatie.sql")
class JdbcReservatieRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private static final String RESERVATIES = "reservaties";
    private final JdbcReservatieRepository reservatieRepository;

    JdbcReservatieRepositoryTest(JdbcReservatieRepository reservatieRepository) {
        this.reservatieRepository = reservatieRepository;
    }
    @Test
    void create() {
        reservatieRepository.create(new Reservatie(2,2, LocalDateTime.now()));
        assertThat(countRowsInTable(RESERVATIES))
                .isEqualTo(4);

    }

}