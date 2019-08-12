package ru.otus.homework06.dao;

import ru.otus.homework06.domain.Author;
import ru.otus.homework06.domain.Book;
import ru.otus.homework06.domain.Genre;

import java.util.List;

public interface BookDao {

    int count();

    Book getById(int id);

    Book getByTitle(String title);

    List<Book> getAll();

    List<Book> getByAuthor(Author author);

    List<Book> getByGenre(Genre genre);

    void insert(Book book);

    int deleteById(int id);

}
