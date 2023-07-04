package ru.otus.dao;

import ru.otus.domain.Genre;

import java.util.List;

public interface GenreDao {

    void insert(Genre genre);

    List<Genre> getAll();

    Genre getById(Long id);

    void deleteById(Long id);

}