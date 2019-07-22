package ru.otus.homework05.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.homework05.domain.Author;
import ru.otus.homework05.domain.Book;
import ru.otus.homework05.domain.Genre;
import java.util.List;
import java.time.Year;
import java.util.stream.Collectors;

@Service @AllArgsConstructor
public class LibraryServiceImpl implements LibraryService {

    private final DatabaseService databaseService;
    private final ConsoleService consoleService;

    private static final String MESSAGE_COUNT_ENTITIES = "message.countEntities";
    private static final String MESSAGE_ENTER_BOOK_TITLE = "message.enterBookTitle";
    private static final String MESSAGE_ENTER_BOOK_AUTHOR = "message.enterBookAuthor";
    private static final String MESSAGE_ENTER_BOOK_GENRE = "message.enterBookGenre";
    private static final String MESSAGE_ENTER_AUTHOR_FULLNAME = "message.enterAuthorFullname";
    private static final String MESSAGE_ENTER_AUTHOR_BIRTH_DEATH = "message.enterAuthorBirthDeath";
    private static final String MESSAGE_ENTER_GENRE = "message.enterGenre";
    private static final String EMPTY_RESULT_SET = "message.EmptyResultSet";

    private static final int DEFAULT_VALUE_FOR_AUTOINCREMENT_FIELDS = 1;

    @Override
    public void getAllBooks() {
        printBooks(databaseService.getAllBooks());
    }

    @Override
    public void getBookByTitle(String title) {
        Book book = databaseService.getBookByTitle(title);
        consoleService.writeMessage(book);
    }

    @Override
    public void getBooksByAuthor(String author) {
        printBooks(databaseService.getBooksByAuthor(author));
    }

    @Override
    public void getBooksByGenre(String genre) {
        printBooks(databaseService.getBooksByGenre(genre));
    }

    @Override
    public void getAllAuthors() {
        List<Author> authors = databaseService.getAllAuthors();
        if (!(authors).isEmpty()) {
            String joinedAuthors = authors.stream().map(x -> x.getName() + " " + x.getSurname()).collect(Collectors.joining(", "));
            consoleService.writeMessage(joinedAuthors);
        } else {
            consoleService.writeLocalizedMessage(EMPTY_RESULT_SET);
        }
    }

    @Override
    public void getAuthorByBook(String bookTitle) {
        Author author = databaseService.getAuthorByBook(bookTitle);
        consoleService.writeMessage(author);
    }

    @Override
    public void getAllGenres() {
        List<Genre> genres = databaseService.getAllGenres();
        if (!(genres).isEmpty()) {
            String joinedGenres = genres.stream().map(Genre::getGenre).collect(Collectors.joining(", "));
            consoleService.writeMessage(joinedGenres);
        } else {
            consoleService.writeLocalizedMessage(EMPTY_RESULT_SET);
        }
    }

    @Override
    public void getGenreByBook(String bookTitle) {
        Genre genre = databaseService.getGenreByBook(bookTitle);
        consoleService.writeMessage(genre);
    }

    @Override
    public void countEntities() {
        consoleService.writeLocalizedMessage(MESSAGE_COUNT_ENTITIES,
                databaseService.countBooks(),
                databaseService.countAuthors(),
                databaseService.countGenres());
    }

    @Override
    public void getBookById(int id) {
        Book book = databaseService.getBookById(id);
        consoleService.writeMessage(book);
    }

    @Override
    public void getAuthorById(int id) {
        Author author = databaseService.getAuthorById(id);
        consoleService.writeMessage(author);
    }

    @Override
    public void getGenreById(int id) {
        Genre genre = databaseService.getGenreById(id);
        consoleService.writeMessage(genre);
    }

    @Override
    public void addBook() {
        consoleService.writeLocalizedMessage(MESSAGE_ENTER_BOOK_TITLE);
        String title = consoleService.readMessage();
        consoleService.writeLocalizedMessage(MESSAGE_ENTER_BOOK_AUTHOR);
        String[] authorCredentials = consoleService.readMessage().split(" ");
        Author author = databaseService.getAurhorByFullName(authorCredentials[0], authorCredentials[1]);
        consoleService.writeLocalizedMessage(MESSAGE_ENTER_BOOK_GENRE);
        Genre genre = databaseService.getGenreByGenre(consoleService.readMessage());
        databaseService.addBook(new Book(DEFAULT_VALUE_FOR_AUTOINCREMENT_FIELDS, title, author.getId(), genre.getId()));
    }

    @Override
    public void addAuthor() {
        consoleService.writeLocalizedMessage(MESSAGE_ENTER_AUTHOR_FULLNAME);
        String[] authorCredentials = consoleService.readMessage().split(" ");
        consoleService.writeLocalizedMessage(MESSAGE_ENTER_AUTHOR_BIRTH_DEATH);
        String[] authorYears = consoleService.readMessage().split(" ");
        databaseService.addAuthor(new Author(DEFAULT_VALUE_FOR_AUTOINCREMENT_FIELDS,
                authorCredentials[0],
                authorCredentials[1],
                Year.of(Integer.parseInt(authorYears[0])),
                Year.of(Integer.parseInt(authorYears[1]))));
    }

    @Override
    public void addGenre() {
        consoleService.writeLocalizedMessage(MESSAGE_ENTER_GENRE);
        String genre = consoleService.readMessage();
        databaseService.addGenre(new Genre(DEFAULT_VALUE_FOR_AUTOINCREMENT_FIELDS, genre));
    }

    @Override
    public void deleteBook(int id) {
        databaseService.deleteBook(id);
    }

    @Override
    public void deleteAuthor(int id) {
        databaseService.deleteAuthor(id);
    }

    @Override
    public void deleteGenre(int id) {
        databaseService.deleteGenre(id);
    }

    private void printBooks(List<Book> books) {

        if (!(books).isEmpty()) {
            String joinedBooks = books.stream().map(Book::getTitle).collect(Collectors.joining(", "));
            consoleService.writeMessage(joinedBooks);
        } else {
            consoleService.writeLocalizedMessage(EMPTY_RESULT_SET);
        }
    }

}