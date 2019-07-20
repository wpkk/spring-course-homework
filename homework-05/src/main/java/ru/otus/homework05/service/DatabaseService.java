package ru.otus.homework05.service;

import ru.otus.homework05.domain.Author;
import ru.otus.homework05.domain.Book;
import ru.otus.homework05.domain.Genre;

import java.util.List;

public interface DatabaseService {

    List<Book> getAllBooks();

    Book getBookByTitle(String title);

    List<Book> getBooksByAuthor(String author);

    List<Book> getBooksByGenre(String genre);

    List<Author> getAllAuthors();

    List<Genre> getAllGenres();

}
