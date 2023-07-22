package ru.otus.service;

import ru.otus.domain.Author;

/**
 * @author kimetsu - 09.07.2023 - 14:00
 */
public interface AuthorService {
    Author getAuthorById(Long id);
}
