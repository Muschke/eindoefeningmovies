package be.vdab.eindoefeningmovies.repositories;

import be.vdab.eindoefeningmovies.domain.Reservatie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;


@Repository
class JdbcReservatieRepository implements ReservatieRepository{
    private final JdbcTemplate template;
    private final SimpleJdbcInsert insert;

    JdbcReservatieRepository(JdbcTemplate template) {
        this.template = template;
        this.insert = new SimpleJdbcInsert(template).withTableName("reservaties");
    }

    @Override
    public void create(Reservatie reservatie) {
        insert.execute(Map.of("klantId", reservatie.getKlantid(), "filmId", reservatie.getFilmId(),"reservatie", LocalDateTime.now()));
    }
}
