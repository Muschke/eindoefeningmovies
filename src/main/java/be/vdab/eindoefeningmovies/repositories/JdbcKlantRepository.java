package be.vdab.eindoefeningmovies.repositories;

import be.vdab.eindoefeningmovies.domain.Film;
import be.vdab.eindoefeningmovies.domain.Klant;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
class JdbcKlantRepository implements KlantRepository {
    private final JdbcTemplate template;
    private final RowMapper<Klant> klantRowMapper = (result, rowNum) ->
            new Klant(result.getLong("id"), result.getString("familienaam"), result.getString("voornaam"), result.getString("straatNummer"),
                    result.getInt("postcode"), result.getString("gemeente"));

    JdbcKlantRepository(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Klant> findByBevatLetters (String startletters) {
        var sql = "select id, familienaam, voornaam, straatNummer, postcode, gemeente from klanten where familienaam like ? order by familienaam";
        return template.query(sql, klantRowMapper, "%"+ startletters + "%");
    }

    @Override
    public Optional<Klant> findById(long id) {
        try {
            var sql = "select id, familienaam, voornaam, straatNummer, postcode, gemeente from klanten where id = ?";
            return Optional.of(template.queryForObject(sql, klantRowMapper, id));
        } catch (IncorrectResultSizeDataAccessException ex) {
            return Optional.empty();
        }
    }
}
