package ru.otus.service;

import ru.otus.domain.Book;

import java.util.List;

/**
 * @author kimetsu - 09.07.2023 - 13:33
 */
public interface BookService {

    Book insert(Book book);

    List<Book> getAll();

    Book getById(Long id);

    boolean deleteById(Long id);

}
