package ru.otus.homework06.shell;

import lombok.AllArgsConstructor;
import org.springframework.shell.ExitRequest;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.homework06.AppProperties;
import ru.otus.homework06.service.ConsoleService;

import java.util.Locale;

@ShellComponent @ShellCommandGroup(value = "Generic") @AllArgsConstructor
public class GenericCommands {

    private final AppProperties props;

    @ShellMethod("Set the user locale")
    public void setLocale(@ShellOption(value = {"-l", "--language-code"}, help = "Specifies the language code.") String languageCode,
                          @ShellOption(value = {"-c", "--country-code"}, help = "Specifies the country code.") String countryCode) {
        props.setUserLocale(new Locale(languageCode, countryCode));
    }
}

@ShellComponent @ShellCommandGroup(value = "Generic") @AllArgsConstructor
class Quit implements org.springframework.shell.standard.commands.Quit.Command {
    private ConsoleService consoleService;
    private static final String MESSAGE_QUIT = "message.quit";

    @ShellMethod(value = "Exit the shell", key = {"quit", "exit"})
    public void quit() {
        consoleService.writeLocalizedMessage(MESSAGE_QUIT);
        throw new ExitRequest();
    }
}
