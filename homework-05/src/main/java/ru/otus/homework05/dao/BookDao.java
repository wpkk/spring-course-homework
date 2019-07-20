package ru.otus.homework05.dao;

import ru.otus.homework05.domain.Author;
import ru.otus.homework05.domain.Book;
import ru.otus.homework05.domain.Genre;

import java.util.List;

public interface BookDao {

    int count();

    Book getById(int id);

    Book getByTitle(String title);

    List<Book> getAll();

    List<Book> getByAuthor(Author author);

    List<Book> getByGenre(Genre genre);

    int insert(Book book);

    int deleteById(int id);

}
