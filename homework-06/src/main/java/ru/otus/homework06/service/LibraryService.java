package ru.otus.homework06.service;

public interface LibraryService {

    void getAllBooks();

    void getBookById(int id);

    void getBookByTitle(String title);

    void getBooksByAuthor(String author);

    void getBooksByGenre(String genre);

    void getAllAuthors();

    void getAuthorByBook(String bookTitle);

    void getAuthorById(int id);

    void getAllGenres();

    void getGenreByBook(String bookTitle);

    void getGenreById(int id);

    void countEntities();

    void addBook();

    void addAuthor();

    void addGenre();

    void addComment();

    void deleteBook(int id);

    void deleteAuthor(int id);

    void deleteGenre(int id);

    void getAuthorsBornBefore(String year);

    void getAuthorsDiedBeforeAgeOf(String age);

}