package ru.otus.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.otus.dao.BookDao;
import ru.otus.domain.Book;
import ru.otus.service.BookService;

import java.util.List;

/**
 * @author kimetsu - 09.07.2023 - 13:34
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;

    @Override
    public void insert(Book book) {
        bookDao.insert(book);
        log.info("create new book");
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }

    @Override
    public Book getById(Long id) {
        var book = bookDao.getById(id);

        if (book != null) {
            return book;
        } else {
            throw new RuntimeException("Book by id not found!");
        }
    }

    @Override
    public boolean deleteById(Long id) {
        var book = bookDao.getById(id);

        if (book != null) {
            bookDao.deleteById(id);
            return true;
        } else {
            log.error("book by id not found!");
            return false;
        }
    }
}
