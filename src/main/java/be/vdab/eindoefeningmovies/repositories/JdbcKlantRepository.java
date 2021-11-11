package be.vdab.eindoefeningmovies.repositories;

import be.vdab.eindoefeningmovies.domain.Klant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
