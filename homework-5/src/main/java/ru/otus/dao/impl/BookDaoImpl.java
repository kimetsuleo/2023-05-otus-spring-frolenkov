package ru.otus.dao.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
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
        var parameter = new MapSqlParameterSource()
                .addValue("title", book.getTitle())
                .addValue("authorId", book.getAuthor().getId())
                .addValue("genreId", book.getGenre().getId())
                .addValue("publicationAt", book.getPublication_at());

        var keyHolder = new GeneratedKeyHolder();

        this.namedJdbcTemplate
                .update("insert into BOOKS(title, author_id, genre_id, publication_at) VALUES ( :title, :authorId, :genreId, :publicationAt )",
                        parameter,
                        keyHolder);
    }

    @Override
    public List<Book> getAll() {
        return this.namedJdbcTemplate
                .getJdbcTemplate()
                .query("select " +
                                "b.id," +
                                "b.title," +
                                "a.id as author_id," +
                                "a.firstName," +
                                "a.lastName," +
                                "a.dof," +
                                "g.id as genre_id," +
                                "g.title as genre_title," +
                                "b.publication_at " +
                                "from BOOKS as b " +
                                "join AUTHORS as a on a.id = b.author_id " +
                                "join GENRES as g on g.id = b.genre_id",
                        new BookMapper());
    }

    @Override
    public Book getById(Long id) {
        var parameter = new MapSqlParameterSource()
                .addValue("id", id);

        return this.namedJdbcTemplate
                .queryForObject(
                        "select " +
                                "b.id," +
                                "b.title," +
                                "a.id as author_id," +
                                "a.firstName," +
                                "a.lastName," +
                                "a.dof," +
                                "g.id as genre_id," +
                                "g.title as genre_title," +
                                "b.publication_at " +
                                "from BOOKS as b " +
                                "join AUTHORS as a on a.id = b.author_id " +
                                "join GENRES as g on g.id = b.genre_id" +
                                " where b.id = :id",
                        parameter,
                        new BookMapper()
                );
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
