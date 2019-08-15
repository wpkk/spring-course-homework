package ru.otus.homework06.dao;

import ru.otus.homework06.domain.Book;
import ru.otus.homework06.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreDao {

    int count();

    Optional<Genre> getById(int id);

    Optional<Genre> getByGenre(String genre);

    Optional<Genre> getByBook(Book book);

    List<Genre> getAll();

    void insert(Genre genre);

    int deleteById(int id);

}
