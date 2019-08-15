package ru.otus.homework06.service;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.otus.homework06.domain.Author;
import ru.otus.homework06.domain.Book;
import ru.otus.homework06.domain.Genre;

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
    private static final String MESSAGE_EMPTY_RESULT_SET = "message.EmptyResultSet";

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
        printAuthors(databaseService.getAllAuthors());
    }

    @Override
    public void getAuthorByBook(String bookTitle) {
        Author author = databaseService.getAuthorByBook(bookTitle).orElseThrow(() -> new EmptyResultDataAccessException(1));
        consoleService.writeMessage(author);
    }

    @Override
    public void getAllGenres() {
        List<Genre> genres = databaseService.getAllGenres();
        if (!(genres).isEmpty()) {
            String joinedGenres = genres.stream().map(Genre::getGenre).collect(Collectors.joining(", "));
            consoleService.writeMessage(joinedGenres);
        } else {
            consoleService.writeLocalizedMessage(MESSAGE_EMPTY_RESULT_SET);
        }
    }

    @Override
    public void getGenreByBook(String bookTitle) {
        Genre genre = databaseService.getGenreByBook(bookTitle).orElseThrow(() -> new EmptyResultDataAccessException(1));
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
        Book book = databaseService.getBookById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
        consoleService.writeMessage(book);
    }

    @Override
    public void getAuthorById(int id) {
        Author author = databaseService.getAuthorById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
        consoleService.writeMessage(author);
    }

    @Override
    public void getGenreById(int id) {
        Genre genre = databaseService.getGenreById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
        consoleService.writeMessage(genre);
    }

    @Override
    public void addBook() {
        consoleService.writeLocalizedMessage(MESSAGE_ENTER_BOOK_TITLE);
        String title = consoleService.readMessage();
        consoleService.writeLocalizedMessage(MESSAGE_ENTER_BOOK_AUTHOR);
        String[] authorCredentials = consoleService.readMessage().split(" ");
        Author author = databaseService.getAuthorByFullName(authorCredentials[0], authorCredentials[1]).orElseThrow(() -> new EmptyResultDataAccessException(1));
        consoleService.writeLocalizedMessage(MESSAGE_ENTER_BOOK_GENRE);
        Genre genre = databaseService.getGenreByGenre(consoleService.readMessage()).orElseThrow(() -> new EmptyResultDataAccessException(1));
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setGenre(genre);
        databaseService.addBook(book);
    }

    @Override
    public void addAuthor() {
        consoleService.writeLocalizedMessage(MESSAGE_ENTER_AUTHOR_FULLNAME);
        String[] authorCredentials = consoleService.readMessage().split(" ");
        consoleService.writeLocalizedMessage(MESSAGE_ENTER_AUTHOR_BIRTH_DEATH);
        String[] authorYears = consoleService.readMessage().split(" ");
        Author author = new Author();
        author.setName(authorCredentials[0]);
        author.setSurname(authorCredentials[1]);
        author.setBirth(Year.of(Integer.parseInt(authorYears[0])));
        author.setDeath(Year.of(Integer.parseInt(authorYears[1])));
        databaseService.addAuthor(author);
    }

    @Override
    public void addGenre() {
        consoleService.writeLocalizedMessage(MESSAGE_ENTER_GENRE);
        String genreValue = consoleService.readMessage();
        Genre genre = new Genre();
        genre.setGenre(genreValue);
        databaseService.addGenre(genre);
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

    @Override
    public void getAuthorsBornBefore(String year) {
        printAuthors(databaseService.getAllAuthors().stream().filter(x -> x.getBirth().isBefore(Year.of(Integer.parseInt(year)))).collect(Collectors.toList()));
    }

    @Override
    public void getAuthorsDiedBeforeAgeOf(String age) {
        printAuthors(databaseService.getAllAuthors().stream().filter(x -> x.getDeath().getValue() - x.getBirth().getValue() < Integer.valueOf(age)).collect(Collectors.toList()));
    }

    private void printBooks(List<Book> books) {
        if (!(books).isEmpty()) {
            String joinedBooks = books.stream().map(Book::getTitle).collect(Collectors.joining(", "));
            consoleService.writeMessage(joinedBooks);
        } else {
            consoleService.writeLocalizedMessage(MESSAGE_EMPTY_RESULT_SET);
        }
    }

    private void printAuthors(List<Author> authors) {
        if (!(authors).isEmpty()) {
            String joinedAuthors = authors.stream().map(x -> x.getName() + " " + x.getSurname()).collect(Collectors.joining(", "));
            consoleService.writeMessage(joinedAuthors);
        } else {
            consoleService.writeLocalizedMessage(MESSAGE_EMPTY_RESULT_SET);
        }
    }

}