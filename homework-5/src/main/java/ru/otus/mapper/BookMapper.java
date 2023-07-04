package ru.otus.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.otus.domain.Author;
import ru.otus.domain.Book;
import ru.otus.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Book.builder()
                .id(rs.getLong("id"))
                .title(rs.getString("title"))
                .author(rs.getObject("author_id", Author.class))
                .genre(rs.getObject("genre_id", Genre.class))
                .publication_at(rs.getDate("publication_at").toLocalDate())
                .build()
                ;
    }
}
