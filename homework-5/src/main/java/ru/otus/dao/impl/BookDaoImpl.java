package ru.otus.dao.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.otus.dao.BookDao;
import ru.otus.domain.Book;
import ru.otus.mapper.BookMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class BookDaoImpl implements BookDao {

    private final NamedParameterJdbcTemplate namedJdbcTemplate;

    @Override
    public void insert(Book book) {
        Map<String, Object> parameter = new HashMap<>() {{
            put("title", book.getTitle());
            put("author_id", book.getAuthor());
            put("genre_id", book.getGenre());
            put("publication_at", book.getPublication_at());
        }};

        this.namedJdbcTemplate
                .update("insert into BOOKS(title, author_id, genre_id, publication_at) VALUES ( :title, :author_id, :genre_id, :publication_at )", parameter);
    }

    @Override
    public List<Book> getAll() {
        return this.namedJdbcTemplate.getJdbcTemplate().query("select * from BOOKS", new BookMapper());
    }

    @Override
    public Book getById(Long id) {
        Map<String, Object> parameter = new HashMap<>() {{
            put("id", id);
        }};

        return this.namedJdbcTemplate.queryForObject("select * from BOOKS where ID = :id", parameter, new BookMapper());
    }

    @Override
    public void deleteById(Long id) {
        Map<String, Object> parameter = new HashMap<>() {{
            put("id", id);
        }};

        this.namedJdbcTemplate
                .update("delete from BOOKS where ID = :id", parameter);
    }
}
