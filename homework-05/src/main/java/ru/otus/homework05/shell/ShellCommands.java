package ru.otus.homework05.shell;

import lombok.AllArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.homework05.service.ConsoleService;
import ru.otus.homework05.service.LibraryService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@ShellComponent @AllArgsConstructor
public class ShellCommands {

    private final LibraryService libraryService;
    private final ConsoleService consoleService;

    @ShellMethod(value = "Prints titles of all books", key = {"books", "get-books"})
    public void getBooks(@ShellOption(value = {"-t", "--title"}, defaultValue = ShellOption.NULL) String title,
                         @ShellOption(value = {"-a", "--author"}, defaultValue = ShellOption.NULL) String author,
                         @ShellOption(value = {"-g", "--genre"}, defaultValue = ShellOption.NULL) String genre) {

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

    private boolean checkForMutualExclusivity(List<String> mutuallyExclusiveParameters) {
        if (mutuallyExclusiveParameters.stream().filter(Objects::nonNull).count() > 1) {
            consoleService.writeMessage("Please specify only one search criteria (title/author/genre).");
            return false;
        } else {
            return true;
        }
    }


}
