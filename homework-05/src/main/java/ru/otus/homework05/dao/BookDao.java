package ru.otus.homework05.dao;

import ru.otus.homework05.domain.Book;

import java.util.List;

public interface BookDao {

    int count();

    Book getById(int id);

    List<Book> getAll();

    List<Book> getByAuthor(String author);

    List<Book> getByGenre(String genre);

    int insert(Book book);

    int deleteById(Book book);

}
