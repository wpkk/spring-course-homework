package ru.otus.homework06.dao;

import ru.otus.homework06.domain.Author;
import ru.otus.homework06.domain.Book;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {

    int count();

    Optional<Author> getById(int id);

    Optional<Author> getBySurname(String surname);

    Optional<Author> getByFullName(String name, String surname);

    Optional<Author> getByBook(Book book);

    List<Author> getAll();

    void insert(Author author);

    int deleteById(int id);

}