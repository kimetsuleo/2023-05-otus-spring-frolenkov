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

        var author = Author.builder()
                .id(rs.getLong("author_id"))
                .firstName(rs.getString("firstName"))
                .lastName(rs.getString("lastName"))
                .dof(rs.getDate("dof").toLocalDate())
                .build();

        var genre = Genre.builder()
                .id(rs.getLong("genre_id"))
                .title(rs.getString("genre_title"))
                .build();

        return Book.builder()
                .id(rs.getLong("id"))
                .title(rs.getString("title"))
                .author(author)
                .genre(genre)
                .publication_at(rs.getDate("publication_at").toLocalDate())
                .build()
                ;
    }
}
