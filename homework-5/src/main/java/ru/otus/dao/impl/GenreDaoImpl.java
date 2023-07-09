package ru.otus.dao.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.otus.dao.GenreDao;
import ru.otus.domain.Genre;
import ru.otus.mapper.GenreMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class GenreDaoImpl implements GenreDao {

    private final NamedParameterJdbcTemplate namedJdbcTemplate;

    @Override
    public void insert(Genre genre) {
        Map<String, Object> parameter = new HashMap<>() {{
            put("title", genre.getTitle());
        }};

        this.namedJdbcTemplate.update("insert into GENRES(title) values (:title)", parameter);
    }

    @Override
    public List<Genre> getAll() {
        return this.namedJdbcTemplate.getJdbcTemplate().query("select * from GENRES", new GenreMapper());
    }

    @Override
    public Genre getById(Long id) {
        Map<String, Object> parameter = new HashMap<>() {{
            put("id", id);
        }};

        return this.namedJdbcTemplate
                .queryForObject("select * from GENRES where id = :id", parameter, new GenreMapper());
    }

    @Override
    public void deleteById(Long id) {
        Map<String, Object> parameter = new HashMap<>() {{
            put("id", id);
        }};

        this.namedJdbcTemplate.update("delete from GENRES where id = :id", parameter);
    }
}
