package ru.otus.homework05.service;

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

    void  getGenreById(int id);

    void countEntities();

    void addBook();

    void addAuthor();

    void addGenre();
}
