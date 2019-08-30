package ru.otus.homework06.service;

public interface LibraryService {

    void getAllBooks();

    void getBookById(long id);

    void getBookByTitle(String title);

    void getBooksByAuthor(String author);

    void getBooksByGenre(String genre);

    void getAllAuthors();

    void getAuthorByBook(String bookTitle);

    void getAuthorById(long id);

    void getAllGenres();

    void getGenreByBook(String bookTitle);

    void getGenreById(long id);

    void countEntities();

    void addBook();

    void addAuthor();

    void addGenre();

    void addComment();

    void deleteBook(long id);

    void deleteAuthor(long id);

    void deleteGenre(long id);

    void getAuthorsBornBefore(String year);

    void getAuthorsDiedBeforeAgeOf(String age);

    void getAllComments();

    void getCommentsByBook(String bookTitle);
}