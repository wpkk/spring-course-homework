package ru.otus.homework05.service;

import ru.otus.homework05.domain.Author;
import ru.otus.homework05.domain.Book;
import ru.otus.homework05.domain.Genre;

import java.util.List;

public interface DatabaseService {

    List<Book> getAllBooks();

    Book getBookById(int id);

    Book getBookByTitle(String title);

    List<Book> getBooksByAuthor(String author);

    List<Book> getBooksByGenre(String genre);

    List<Author> getAllAuthors();

    Author getAuthorById(int id);

    Author getAuthorByBook(String bookTitle);

    Author getAurhorByFullName(String name, String surname);

    List<Genre> getAllGenres();

    Genre getGenreById(int id);

    Genre getGenreByBook(String bookTitle);

    Genre getGenreByGenre(String genre);

    int countBooks();

    int countAuthors();

    int countGenres();

    void addBook(Book book);

    void addAuthor(Author author);

    void addGenre(Genre genre);

    void deleteBook(int id);

    void deleteAuthor(int id);

    void deleteGenre(int id);
}
