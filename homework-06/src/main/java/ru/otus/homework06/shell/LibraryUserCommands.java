package ru.otus.homework06.shell;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.homework06.service.ConsoleService;
import ru.otus.homework06.service.LibraryService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@ShellComponent @ShellCommandGroup("LibraryUser") @AllArgsConstructor
public class LibraryUserCommands {

    private final LibraryService libraryService;
    private final ConsoleService consoleService;

    private static final String MESSAGE_EMPTY_RESULT_SET = "message.EmptyResultSet";
    private static final String MESSAGE_EXCESSIVE_SEARCH_CRITERIA = "message.ExcessiveSearchCriteria";

    @ShellMethod(value = "Prints titles of books", key = {"books", "get-books"})
    public void getBooks(@ShellOption(value = {"-t", "--title"}, help = "Filters books by title and prints complete book info", defaultValue = ShellOption.NULL) String title,
                         @ShellOption(value = {"-a", "--author"}, help = "Filters books by author's surname", defaultValue = ShellOption.NULL) String author,
                         @ShellOption(value = {"-g", "--genre"}, help = "Filters books by genre", defaultValue = ShellOption.NULL) String genre) {

        List<String> parameters = new ArrayList<>(Arrays.asList(title, author, genre));

        try {
            if (checkForMutualExclusivity(parameters)) {
                if (title != null)
                    libraryService.getBookByTitle(title);
                else if (author != null)
                    libraryService.getBooksByAuthor(author);
                else if (genre != null)
                    libraryService.getBooksByGenre(genre);
                else libraryService.getAllBooks();
            }
        } catch (EmptyResultDataAccessException e) {
            consoleService.writeLocalizedMessage(MESSAGE_EMPTY_RESULT_SET);
        }
    }

    @ShellMethod(value = "Prints authors of books", key = {"authors", "get-authors"})
    public void getAuthors(@ShellOption(value = {"-b", "--book"}, help = "Filters authors by book title and prints complete author info", defaultValue = ShellOption.NULL) String bookTitle,
                           @ShellOption(value = {"--born-before"}, help = "Filters authors who were born before the specified year", defaultValue = ShellOption.NULL) String year,
                           @ShellOption(value = "--died-before-the-age-of", help = "Filters authors who died before the specified age", defaultValue = ShellOption.NULL) String age) {
        List<String> parameters = new ArrayList<>(Arrays.asList(bookTitle, year, age));

        try {
            if (checkForMutualExclusivity(parameters)) {
                if (bookTitle != null)
                    libraryService.getAuthorByBook(bookTitle);
                else if (year != null)
                    libraryService.getAuthorsBornBefore(year);
                else if (age != null)
                    libraryService.getAuthorsDiedBeforeAgeOf(age);
                else
                    libraryService.getAllAuthors();
            }
        } catch (EmptyResultDataAccessException e) {
            consoleService.writeLocalizedMessage(MESSAGE_EMPTY_RESULT_SET);
        }
    }

    @ShellMethod(value = "Prints genres of books", key = {"genres", "get-genres"})
    public void getGenres(@ShellOption(value = {"-b", "--book"}, help = "Filters genres by book title and prints complete title info", defaultValue = ShellOption.NULL) String bookTitle) {
        try {
            if (bookTitle != null)
                libraryService.getGenreByBook(bookTitle);
            else
                libraryService.getAllGenres();
        } catch (EmptyResultDataAccessException e) {
            consoleService.writeLocalizedMessage(MESSAGE_EMPTY_RESULT_SET);
        }
    }

    @ShellMethod(key = {"comments"}, value = "Prints comments")
    public void comments(@ShellOption(value = {"-b", "--book"}, help = "Filters genres by book title and prints complete title info", defaultValue = ShellOption.NULL) String bookTitle) {
        try {
            if (bookTitle != null)
                libraryService.getCommentsByBook(bookTitle);
            else
                libraryService.getAllComments();
        } catch (EmptyResultDataAccessException e) {
            consoleService.writeLocalizedMessage(MESSAGE_EMPTY_RESULT_SET);
        }
    }

    @ShellMethod(key = {"add-comment"}, value = "Adds comments")
    public void addComment() {
        try {
            libraryService.addComment();
        } catch (EmptyResultDataAccessException e) {
            consoleService.writeLocalizedMessage(MESSAGE_EMPTY_RESULT_SET);
        }
    }

    private boolean checkForMutualExclusivity(List<String> mutuallyExclusiveParameters) {
        if (mutuallyExclusiveParameters.stream().filter(Objects::nonNull).count() > 1) {
            consoleService.writeLocalizedMessage(MESSAGE_EXCESSIVE_SEARCH_CRITERIA);
            return false;
        } else {
            return true;
        }
    }
}
