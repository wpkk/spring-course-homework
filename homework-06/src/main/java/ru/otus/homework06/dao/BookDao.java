package ru.otus.homework06.dao;

import ru.otus.homework06.domain.Author;
import ru.otus.homework06.domain.Book;
import ru.otus.homework06.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface BookDao {

    int count();

    Optional<Book> getById(int id);

    Book getByTitle(String title);

    List<Book> getAll();

    List<Book> getByAuthor(Author author);

    List<Book> getByGenre(Genre genre);

    void insert(Book book);

    void deleteById(int id);

}
