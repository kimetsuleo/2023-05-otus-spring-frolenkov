package ru.otus.dao.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.EmptyResultDataAccessException;
import ru.otus.domain.Genre;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


/**
 * @author kimetsu - 08.07.2023 - 21:51
 */

@Import(GenreDaoImpl.class)
@JdbcTest
@DisplayName("test genres DAO")
class GenreDaoImplTest {

    private final Genre FIRST_GENRE = new Genre(1L, "Triller");

    private final Genre INSERT_GENRE_DATA = Genre.builder().title("Adventure").build();

    private final Genre EXISTING_GENRE = Genre.builder().id(8L).title("Adventure").build();

    @Autowired
    private GenreDaoImpl genreDao;

    @Test
    @DisplayName("insert new Genre")
    void shouldInsertNewGenre() {
        Genre insertedEntity = genreDao.insert(INSERT_GENRE_DATA);

        var actualGenre = genreDao.getById(insertedEntity.getId());

        assertThat(actualGenre).usingRecursiveComparison().isEqualTo(EXISTING_GENRE);
    }

    @Test
    @DisplayName("return all genres")
    void shouldReturnAllGenres() {
        var all = genreDao.getAll();
        assertThat(all).isNotNull();
    }

    @Test
    @DisplayName("return genre by id if it present")
    void shouldReturnGenreById() {
        var actualGenre = genreDao.getById(FIRST_GENRE.getId());

        assertThat(actualGenre).usingRecursiveComparison().isEqualTo(FIRST_GENRE);
    }

    @Test
    @DisplayName("should delete genre")
    void shouldDeleteGenre() {
        genreDao.deleteById(FIRST_GENRE.getId());

        assertThatThrownBy(() -> genreDao.getById(FIRST_GENRE.getId())).isInstanceOf(EmptyResultDataAccessException.class);

    }

}