package ru.otus.homework07.dao;

import ru.otus.homework07.domain.Book;
import ru.otus.homework07.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreDao {

    int count();

    Optional<Genre> getById(long id);

    Genre getByGenre(String genre);

    Genre getByBook(Book book);

    List<Genre> getAll();

    void insert(Genre genre);

    void deleteById(long id);

}
