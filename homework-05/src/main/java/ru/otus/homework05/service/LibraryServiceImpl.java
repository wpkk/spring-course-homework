package ru.otus.homework05.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.homework05.domain.Author;
import ru.otus.homework05.domain.Book;
import ru.otus.homework05.domain.Genre;

import java.util.stream.Collectors;

@Service @AllArgsConstructor
public class LibraryServiceImpl implements LibraryService {

    private final DatabaseService databaseService;
    private final ConsoleService consoleService;

    @Override
    public void getAllBooks() {
        String allBooks = databaseService.getAllBooks().stream().map(Book::getTitle).collect(Collectors.joining(", "));
        consoleService.writeMessage(allBooks);
    }

    @Override
    public void getBookByTitle(String title) {
        Book book = databaseService.getBookByTitle(title);
        consoleService.writeMessage(book);
    }

    @Override
    public void getBooksByAuthor(String author) {
        String booksByAuthor = databaseService.getBooksByAuthor(author).stream().map(Book::getTitle).collect(Collectors.joining(", "));
        consoleService.writeMessage(booksByAuthor);
    }

    @Override
    public void getBooksByGenre(String genre) {
        String booksByGenre = databaseService.getBooksByGenre(genre).stream().map(Book::getTitle).collect(Collectors.joining(", "));
        consoleService.writeMessage(booksByGenre);
    }

    @Override
    public void getAllAuthors() {
        String allAuthors = databaseService.getAllAuthors().stream().map(x -> x.getName() + " " + x.getSurname()).collect(Collectors.joining(", "));
        consoleService.writeMessage(allAuthors);
    }

    @Override
    public void getAuthorByBook(String bookTitle) {
        Author author = databaseService.getAuthorByBook(bookTitle);
        consoleService.writeMessage(author);
    }

    @Override
    public void getAllGenres() {
        String allGenres = databaseService.getAllGenres().stream().map(Genre::getGenre).collect(Collectors.joining(", "));
        consoleService.writeMessage(allGenres);
    }

    @Override
    public void getGenreByBook(String bookTitle) {
        Genre genre = databaseService.getGenreByBook(bookTitle);
        consoleService.writeMessage(genre);
    }
}