package ru.otus.dao.impl;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.otus.dao.AuthorDao;
import ru.otus.domain.Author;
import ru.otus.mapper.AuthorMapper;

import java.util.HashMap;
import java.util.List;

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
    public void insert(Author author) {
        var parameterMap = new HashMap<String, Object>() {{
            put("firstName", author.getFirstName());
            put("lastName", author.getLastName());
            put("dof", author.getDof());
        }};

        this.namedParameterJdbcTemplate.update(
                """
                        insert into authors(firstName, lastName, dof)
                        values (:firstName,:lastName,:dof);
                        """,
                parameterMap
        );
    }

    @Override
    public List<Author> getAll() {
        return this.namedParameterJdbcTemplate.getJdbcTemplate().query("select * from authors", new AuthorMapper());
    }

    @Override
    public Author getById(Long id) {
        var parameterMap = new HashMap<String, Object>() {{
            put("id", id);
        }};

        return this.namedParameterJdbcTemplate.queryForObject("select * from AUTHORS where ID = :id", parameterMap, new AuthorMapper());
    }

}
