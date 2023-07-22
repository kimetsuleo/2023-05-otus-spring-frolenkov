package ru.otus.dao.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.EmptyResultDataAccessException;
import ru.otus.domain.Author;
import ru.otus.domain.Book;
import ru.otus.domain.Genre;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author kimetsu - 08.07.2023 - 22:59
 */

@Import(BookDaoImpl.class)
@JdbcTest
@DisplayName("class for test BookDao")
class BookDaoImplTest {

    private final Book EXPECTED_BOOK = Book.builder()
            .id(1L)
            .title("The Witcher")
            .author(Author.builder().id(3L).firstName("Anjey").lastName("Sapkowski").dof(LocalDate.of(1948, 6, 12)).build())
            .genre(Genre.builder().id(7L).title("Fantasy").build())
            .publication_at(LocalDate.of(2021, 1, 1))
            .build();


    private final Author EXISTING_AUTHOR = Author.builder()
            .id(1L)
            .firstName("Jack")
            .lastName("London")
            .dof(LocalDate.of(1876, 1, 12))
            .build();

    private final Genre EXISTING_GENRE = Genre.builder().id(1L).title("Triller").build();

    private final Book TEST_BOOK = Book.builder()
            .id(7L)
            .title("test")
            .author(EXISTING_AUTHOR)
            .genre(EXISTING_GENRE)
            .publication_at(LocalDate.of(2023, 1, 1))
            .build();


    @Autowired
    private BookDaoImpl bookDao;

    @Test
    @DisplayName("should insert new Book")
    void insert() {
        var book = Book.builder()
                .title("test")
                .author(EXISTING_AUTHOR)
                .genre(EXISTING_GENRE)
                .publication_at(LocalDate.of(2023, 1, 1))
                .build();

        Book insertedBook = bookDao.save(book);

        var actualBook = bookDao.getById(insertedBook.getId());

        assertThat(actualBook).usingRecursiveComparison().isEqualTo(TEST_BOOK);
    }

    @Test
    @DisplayName("should get all books")
    void getAll() {
        var all = bookDao.getAll();

        assertThat(all).isNotNull();
    }

    @Test
    @DisplayName("should get book by id")
    void getById() {
        Book book = bookDao.getById(1L);

        assertThat(book).usingRecursiveComparison().isEqualTo(EXPECTED_BOOK);
    }

    @Test
    @DisplayName("should delete book by id")
    void deleteById() {
        bookDao.deleteById(1L);

        assertThatThrownBy(() -> bookDao.getById(1L)).isInstanceOf(EmptyResultDataAccessException.class);
    }
}