package ru.otus.homework05.dao;

import ru.otus.homework05.domain.Author;
import ru.otus.homework05.domain.Book;

import java.util.List;

public interface AuthorDao {

    int count();

    Author getById(int id);

    Author getByBook(Book book);

    List<Author> getAll();

    int insert(Author author);

    int deleteById(int id);

}
