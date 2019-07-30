package ru.otus.homework05.shell;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.homework05.service.ConsoleService;
import ru.otus.homework05.service.LibraryService;

@ShellComponent @ShellCommandGroup(value = "LibraryAdmin") @AllArgsConstructor
public class LibraryAdminCommands {

    private final LibraryService libraryService;
    private final ConsoleService consoleService;

    private final static String MESSAGE_WRONG_ENTITY_TYPE = "message.wrongEntityType";
    private final static String MESSAGE_EMPTY_RESULT_SET = "message.EmptyResultSet";
    private final static String MESSAGE_NO_ROWS_DELETED = "message.NoRowsDeleted";


    @ShellMethod(key = {"count", "count-entities"}, value = "Counts database entities.")
    public void countEntities() {
        libraryService.countEntities();
    }

    @ShellMethod(key = {"id", "get-by-id"}, value = "Gets entity by its id. Book is the default entity.")
    public void getById(@ShellOption(value = {"-t", "--entity-type"}, defaultValue = "book", help = "Specifies the entity type book/author/genre.") String entityType,
                        @ShellOption(value = "-v", defaultValue = ShellOption.NONE, help = "Specifies the id to search for.") int value) {
        try {
            switch (entityType) {
                case "book": libraryService.getBookById(value);
                    break;
                case "author": libraryService.getAuthorById(value);
                    break;
                case "genre": libraryService.getGenreById(value);
                    break;
                default: consoleService.writeLocalizedMessage(MESSAGE_WRONG_ENTITY_TYPE);
            }
        } catch (EmptyResultDataAccessException e) {
            consoleService.writeLocalizedMessage(MESSAGE_EMPTY_RESULT_SET);
        }
    }

    @ShellMethod(key = {"add", "add-entity"}, value = "Adds entity of specified type. Book is the default type.")
    public void addEntity(@ShellOption(value = {"-t", "--entity-type"}, defaultValue = "book", help = "Specifies the entity type book/author/genre.") String entityType) {
        try {
            switch (entityType) {
                case "book": libraryService.addBook();
                    break;
                case "author": libraryService.addAuthor();
                    break;
                case "genre": libraryService.addGenre();
                    break;
                default: consoleService.writeLocalizedMessage(MESSAGE_WRONG_ENTITY_TYPE);
            }
        } catch (EmptyResultDataAccessException e) {
            consoleService.writeLocalizedMessage(MESSAGE_EMPTY_RESULT_SET);
        }
    }

    @ShellMethod(key = {"del", "delete", "delete-entity"}, value = "Removes entity of specified type. Book is the default type.")
    public void deleteEntity(@ShellOption(value = {"-t", "--entity-type"}, defaultValue = "book", help = "Specifies the entity type book/author/genre.") String entityType,
                             @ShellOption(value = "-v", defaultValue = ShellOption.NONE, help = "Specifies the id to search for.") int value) {
        try {
            switch (entityType) {
                case "book":
                    libraryService.deleteBook(value);
                    break;
                case "author":
                    libraryService.deleteAuthor(value);
                    break;
                case "genre":
                    libraryService.deleteGenre(value);
                    break;
                default:
                    consoleService.writeLocalizedMessage(MESSAGE_WRONG_ENTITY_TYPE);
            }
        } catch (IllegalArgumentException e) {
            consoleService.writeLocalizedMessage(MESSAGE_NO_ROWS_DELETED);
        }
    }

}
