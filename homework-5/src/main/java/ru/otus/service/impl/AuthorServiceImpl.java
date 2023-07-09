package ru.otus.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.dao.AuthorDao;
import ru.otus.domain.Author;
import ru.otus.service.AuthorService;

/**
 * @author kimetsu - 09.07.2023 - 14:01
 */
@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDao authorDao;

    @Override
    public Author getAuthorById(Long id) {
        return authorDao.getById(id);
    }
}
