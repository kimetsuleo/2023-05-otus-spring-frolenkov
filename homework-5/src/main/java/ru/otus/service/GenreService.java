package ru.otus.service;

import ru.otus.domain.Genre;

/**
 * @author kimetsu - 09.07.2023 - 14:00
 */
public interface GenreService {
    Genre getGenreById(Long id);
}
