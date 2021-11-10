package be.vdab.eindoefeningmovies.repositories;

import be.vdab.eindoefeningmovies.domain.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class JdbcGenreRepository implements GenreRepository {
    private final JdbcTemplate template;
    //geen insert nodig, voorlopig toch
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private  final RowMapper<Genre> genreRowMapper = (result, rowNum) ->
            new Genre(result.getLong("id"), result.getString("naam"));

    JdbcGenreRepository(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Genre> findAll() {
        return template.query("select id, naam from genres order by naam", genreRowMapper);
    }
}
