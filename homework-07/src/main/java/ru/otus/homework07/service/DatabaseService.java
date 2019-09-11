package ru.otus.homework07.service;

import ru.otus.homework07.domain.Author;
import ru.otus.homework07.domain.Book;
import ru.otus.homework07.domain.Comment;
import ru.otus.homework07.domain.Genre;
import ru.otus.homework07.domain.partial.BookTitle;

import java.util.List;
import java.util.Optional;

public interface DatabaseService {

    List<Book> getAllBooks();

    Optional<Book> getBookById(long id);

    Book getBookByTitle(String title);

    List<Book> getBooksByAuthor(String author);

    List<Book> getBooksByGenre(String genre);

    List<Author> getAllAuthors();

    Optional<Author> getAuthorById(long id);

    Author getAuthorByBook(String bookTitle);

    Author getAuthorByFullName(String name, String surname);

    List<Genre> getAllGenres();

    Optional<Genre> getGenreById(long id);

    Genre getGenreByBook(String bookTitle);

    Genre getGenreByGenre(String genre);

    int countBooks();

    int countAuthors();

    int countGenres();

    void addBook(Book book);

    void addAuthor(Author author);

    void addGenre(Genre genre);

    void addComment(Comment comment);

    void deleteBook(long id);

    void deleteAuthor(long id);

    void deleteGenre(long id);

    List<Comment> getAllComments();

    List<Comment> getCommentByBook(String bookTitle);

    BookTitle getBookTitleByTitle(String title);
}
