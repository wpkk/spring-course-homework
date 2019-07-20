package ru.otus.homework05.service;

public interface LibraryService {

    void getAllBooks();

    void getBookByTitle(String title);

    void getBooksByAuthor(String author);

    void getBooksByGenre(String genre);
}
