package ru.otus.dao;

import ru.otus.domain.Author;

import java.util.List;

/**
 * @author kimetsu - 02.07.2023 - 23:02
 */
public interface AuthorDao {

    Author insert(Author author);

    List<Author> getAll();

    Author getById(Long id);

}
