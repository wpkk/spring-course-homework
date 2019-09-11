package ru.otus.homework07.dao;

import ru.otus.homework07.domain.Author;
import ru.otus.homework07.domain.Book;
import ru.otus.homework07.domain.Genre;
import ru.otus.homework07.domain.partial.BookTitle;

import java.util.List;
import java.util.Optional;

public interface BookDao {

    int count();

    Optional<Book> getById(long id);

    Book getByTitle(String title);

    List<Book> getAll();

    List<Book> getByAuthor(Author author);

    List<Book> getByGenre(Genre genre);

    void insert(Book book);

    void deleteById(long id);

    BookTitle getBookTitleByTitle(String title);
}
