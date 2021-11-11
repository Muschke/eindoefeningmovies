package be.vdab.eindoefeningmovies.repositories;

import be.vdab.eindoefeningmovies.DTO.FilmsPerGenre;
import be.vdab.eindoefeningmovies.domain.Film;
import be.vdab.eindoefeningmovies.domain.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
class JdbcFilmRepository implements FilmRepository{
    private final JdbcTemplate template;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final RowMapper<FilmsPerGenre> filmsPerGenreRowMapper = (result, rowNum) ->
            new FilmsPerGenre(result.getLong("id"), result.getLong("genreId"));
    private final RowMapper<Film> filmRowMapper = (result, rowNum) ->
            new Film(result.getLong("id"), result.getLong("genreId"), result.getString("titel"), result.getInt("voorraad"),
                    result.getInt("gereserveerd"), result.getBigDecimal("prijs"));


    public JdbcFilmRepository(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<FilmsPerGenre> findAllPerGenre(long id) {
        var sql ="select id, genreId from films where genreId = ?";
        return template.query(sql, filmsPerGenreRowMapper, id);
    }

    @Override
    public Optional<Film> findById(long id) {
        try {
            var sql = "select id, genreId, titel, voorraad, gereserveerd, prijs from films where id = ?";
            return Optional.of(template.queryForObject(sql, filmRowMapper, id));
        } catch (IncorrectResultSizeDataAccessException ex) {
            return Optional.empty();
        }
    }
    @Override
    public List<Film> findByIds(Set<Long> ids) {
        if(ids.isEmpty()) {
            return List.of();
        }
        var sql = "select id, genreId, titel, voorraad, gereserveerd, prijs from films where id in (" +
                "?,".repeat(ids.size()-1) +
                "?) order by id";
        return template.query(sql, filmRowMapper, ids.toArray());
    }

    @Override
    public BigDecimal vindTotalePrijsByIds(Set<Long> ids) {
        var sql = "select sum(prijs) from films where id in (" +
                "?,".repeat(ids.size()-1) +
                "?)";
        return template.queryForObject(sql, BigDecimal.class, ids);
    }
    @Override
    public void update(long id) {
        var sql = "update films set gereserveerd = gereserveerd + 1 where id = ?";
        template.update(sql, id);
    }
}
