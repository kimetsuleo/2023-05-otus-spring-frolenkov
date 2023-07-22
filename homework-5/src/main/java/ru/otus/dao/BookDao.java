package ru.otus.dao;

import ru.otus.domain.Book;

import java.util.List;

public interface BookDao {

    Book save(Book book);

    List<Book> getAll();

    Book getById(Long id);

    void deleteById(Long id);

}
