package ru.otus.dao.impl;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import ru.otus.dao.AuthorDao;
import ru.otus.domain.Author;
import ru.otus.mapper.AuthorMapper;

import java.util.List;
import java.util.Objects;

/**
 * @author kimetsu - 03.07.2023 - 22:09
 */

@Repository
public class AuthorDaoImpl implements AuthorDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public AuthorDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Author insert(Author author) {
        var parameterMap = new MapSqlParameterSource() {{
            addValue("firstName", author.getFirstName());
            addValue("lastName", author.getLastName());
            addValue("dof", author.getDof());
        }};

        var keyHolder = new GeneratedKeyHolder();

        this.namedParameterJdbcTemplate.update(
                """
                        insert into authors(firstName, lastName, dof)
                        values (:firstName,:lastName,:dof);
                        """,
                parameterMap,
                keyHolder
        );

        var key = Objects.requireNonNull(keyHolder.getKey()).longValue();

        author.setId(key);
        return author;
    }

    @Override
    public List<Author> getAll() {
        return this.namedParameterJdbcTemplate.getJdbcTemplate().query("select * from authors", new AuthorMapper());
    }

    @Override
    public Author getById(Long id) {
        var parameter = new MapSqlParameterSource() {{
            addValue("id", id);
        }};

        return this.namedParameterJdbcTemplate.queryForObject("select * from AUTHORS where ID = :id", parameter, new AuthorMapper());
    }

}
