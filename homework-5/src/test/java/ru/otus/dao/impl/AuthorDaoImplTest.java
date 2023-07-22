package ru.otus.dao.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.otus.domain.Author;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author kimetsu - 08.07.2023 - 22:11
 */


@Import(AuthorDaoImpl.class)
@JdbcTest
@DisplayName("class for test AuthorDao")
class AuthorDaoImplTest {

    private final Author NEW_INSERT_AUTHOR = Author.builder()
            .firstName("Alexsandr")
            .lastName("Pushkin")
            .dof(LocalDate.of(1799, 6, 6))
            .build();

    private final Author NEW_AUTHOR = Author.builder()
            .id(7L)
            .firstName("Alexsandr")
            .lastName("Pushkin")
            .dof(LocalDate.of(1799, 6, 6))
            .build();

    private final Author EXISTING_AUTHOR = Author.builder()
            .id(1L)
            .firstName("Jack")
            .lastName("London")
            .dof(LocalDate.of(1876, 1, 12))
            .build();

    @Autowired
    private AuthorDaoImpl authorDao;

    @Test
    @DisplayName("should insert new author")
    void shouldInsertNewAuthor() {
        Author insertEntity = authorDao.insert(NEW_INSERT_AUTHOR);

        var actualAuthor = authorDao.getById(insertEntity.getId());

        assertThat(actualAuthor).usingRecursiveComparison().isEqualTo(NEW_AUTHOR);
    }

    @Test
    @DisplayName("should return author by id")
    void shouldReturnAuthorById() {
        var actualAuthor = authorDao.getById(EXISTING_AUTHOR.getId());

        assertThat(actualAuthor).usingRecursiveComparison().isEqualTo(EXISTING_AUTHOR);
    }

    @Test
    @DisplayName("should return all authors")
    void shouldReturnAllAuthors() {
        var all = authorDao.getAll();

        assertThat(all).isNotNull();
    }

}