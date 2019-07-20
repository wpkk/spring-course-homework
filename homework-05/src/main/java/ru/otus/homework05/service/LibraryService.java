package ru.otus.homework05.service;

public interface LibraryService {

    void getAllBooks();

    void getBookByTitle(String title);

    void getBooksByAuthor(String author);

    void getBooksByGenre(String genre);

    void getAllAuthors();

    void getAuthorByBook(String bookTitle);

    void getAllGenres();

    void getGenreByBook(String bookTitle);
}
