package ru.otus.homework07.dao;

import ru.otus.homework07.domain.Author;
import ru.otus.homework07.domain.Book;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {

    int count();

    Optional<Author> getById(long id);

    Author getBySurname(String surname);

    Author getByFullName(String name, String surname);

    Author getByBook(Book book);

    List<Author> getAll();

    void insert(Author author);

    void deleteById(long id);

}