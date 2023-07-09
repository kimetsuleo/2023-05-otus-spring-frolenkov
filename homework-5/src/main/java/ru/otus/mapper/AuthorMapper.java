package ru.otus.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.otus.domain.Author;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author kimetsu - 03.07.2023 - 22:20
 */
@Component
public class AuthorMapper implements RowMapper<Author> {
    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Author.builder()
                .id(rs.getLong("id"))
                .firstName(rs.getString("firstName"))
                .lastName(rs.getString("lastName"))
                .dof(rs.getDate("dof").toLocalDate())
                .build();
    }
}
