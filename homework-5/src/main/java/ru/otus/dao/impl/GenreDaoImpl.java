package ru.otus.dao.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import ru.otus.dao.GenreDao;
import ru.otus.domain.Genre;
import ru.otus.mapper.GenreMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class GenreDaoImpl implements GenreDao {

    private final NamedParameterJdbcTemplate namedJdbcTemplate;

    @Override
    public Genre insert(Genre genre) {
        var parameter = new MapSqlParameterSource() {{
            addValue("title", genre.getTitle());
        }};

        var keyHolder = new GeneratedKeyHolder();

        this.namedJdbcTemplate.update("insert into GENRES(title) values (:title)", parameter, keyHolder);

        genre.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());

        return genre;
    }

    @Override
    public List<Genre> getAll() {
        return this.namedJdbcTemplate.getJdbcTemplate().query("select * from GENRES", new GenreMapper());
    }

    @Override
    public Genre getById(Long id) {
        var parameter = new MapSqlParameterSource() {{
            addValue("id", id);
        }};

        return this.namedJdbcTemplate
                .queryForObject("select * from GENRES where id = :id", parameter, new GenreMapper());
    }

    @Override
    public void deleteById(Long id) {
        var parameter = new MapSqlParameterSource() {{
            addValue("id", id);
        }};

        this.namedJdbcTemplate.update("delete from GENRES where id = :id", parameter);
    }
}
