package ru.otus.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.dao.GenreDao;
import ru.otus.domain.Genre;
import ru.otus.service.GenreService;

/**
 * @author kimetsu - 09.07.2023 - 14:02
 */
@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreDao genreDao;

    @Override
    public Genre getGenreById(Long id) {
        return genreDao.getById(id);
    }
}
