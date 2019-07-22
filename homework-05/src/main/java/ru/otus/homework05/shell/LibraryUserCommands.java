package ru.otus.homework05.shell;

import lombok.AllArgsConstructor;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.homework05.service.ConsoleService;
import ru.otus.homework05.service.LibraryService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@ShellComponent @ShellCommandGroup("LibraryUser") @AllArgsConstructor
public class LibraryUserCommands {

    private final LibraryService libraryService;
    private final ConsoleService consoleService;

    @ShellMethod(value = "Prints titles of books", key = {"books", "get-books"})
    public void getBooks(@ShellOption(value = {"-t", "--title"}, help = "Filters books by title and prints complete book info", defaultValue = ShellOption.NULL) String title,
                         @ShellOption(value = {"-a", "--author"}, help = "Filters books by author's surname", defaultValue = ShellOption.NULL) String author,
                         @ShellOption(value = {"-g", "--genre"}, help = "Filters books by genre", defaultValue = ShellOption.NULL) String genre) {

        List<String> parameters = new ArrayList<>(Arrays.asList(title, author, genre));

        if (checkForMutualExclusivity(parameters)) {
            if (title != null)
                libraryService.getBookByTitle(title);
            else if (author != null)
                libraryService.getBooksByAuthor(author);
            else if (genre != null)
                libraryService.getBooksByGenre(genre);
            else libraryService.getAllBooks();
        }
    }

    @ShellMethod(value = "Prints authors of books", key = {"authors", "get-authors"})
    public void getAuthors(@ShellOption(value = {"-b", "--book"}, help = "Filters authors by book title and prints complete author info", defaultValue = ShellOption.NULL) String bookTitle) {
        if (bookTitle != null)
            libraryService.getAuthorByBook(bookTitle);
        else
            libraryService.getAllAuthors();
    }

    @ShellMethod(value = "Prints genres of books", key = {"genres", "get-genres"})
    public void getGenres(@ShellOption(value = {"-b", "--book"}, help = "Filters genres by book title and prints complete title info", defaultValue = ShellOption.NULL) String bookTitle) {
        if (bookTitle != null)
            libraryService.getGenreByBook(bookTitle);
        else
            libraryService.getAllGenres();
    }

    private boolean checkForMutualExclusivity(List<String> mutuallyExclusiveParameters) {
        if (mutuallyExclusiveParameters.stream().filter(Objects::nonNull).count() > 1) {
            consoleService.writeMessage("Please specify only one search criteria (title/author/genre).");
            return false;
        } else {
            return true;
        }
    }

}
