package ru.otus.homework05.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.homework05.domain.Book;

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

    }
}
