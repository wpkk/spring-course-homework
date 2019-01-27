package ru.otus.homework04.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.ExitRequest;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.homework04.LocalizationConfig;
import ru.otus.homework04.service.ExaminationService;

import java.util.Locale;

@ShellComponent
public class ShellCommands {

    private LocalizationConfig localizationConfig;
    private ExaminationService examinationService;

    @Autowired
    public ShellCommands(LocalizationConfig localizationConfig, ExaminationService examinationService) {
        this.localizationConfig = localizationConfig;
        this.examinationService = examinationService;
    }

    @ShellMethod("Sets the user locale")
    public void setLocale(@ShellOption({"-l", "--language-code"}) String languageCode,
                          @ShellOption({"-c", "--country-code"}) String countryCode) {
        localizationConfig.setUserLocale(new Locale(languageCode, countryCode));
    }

    @ShellMethod("Starts the examination")
    public void startExamination() {
        examinationService.startExamination();
    }

}

@ShellComponent
class Quit implements org.springframework.shell.standard.commands.Quit.Command {

    @ShellMethod(value = "Exit the shell", key = {"quit", "exit"})
    public void quit() {
        System.out.println("Thank you for using the examination application!");
        throw new ExitRequest();
    }

}
