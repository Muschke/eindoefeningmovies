package be.vdab.eindoefeningmovies.repositories;

import be.vdab.eindoefeningmovies.domain.Film;
import be.vdab.eindoefeningmovies.domain.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
class JdbcFilmRepository implements FilmRepository{
    private final JdbcTemplate template;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final RowMapper<Film> filmRowMapper = (result, rowNum) ->
            new Film(result.getLong("id"), result.getLong("genreId"),result.getString("titel"), result.getInt("voorraad"), result.getInt("gereserveerd"), result.getBigDecimal("prijs"));
    public JdbcFilmRepository(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Film> findAllPerGenre(long id) {
        var sql ="select id, genreId, titel, voorraad, gereserveerd, prijs from films where genreId = ?";
        return template.query(sql, filmRowMapper, id);
    }


}
