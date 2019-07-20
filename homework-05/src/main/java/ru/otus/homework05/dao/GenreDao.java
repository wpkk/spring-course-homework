package ru.otus.homework05.dao;

import ru.otus.homework05.domain.Book;
import ru.otus.homework05.domain.Genre;

import java.util.List;

public interface GenreDao {

    int count();

    Genre getById(int id);

    Genre getByGenre(String genre);

    Genre getByBook(Book book);

    List<Genre> getAll();

    int insert(Genre genre);

    int deleteById(int id);

}
