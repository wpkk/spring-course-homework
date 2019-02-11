package ru.otus.homework04.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.ExitRequest;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.homework04.AppProperties;
import ru.otus.homework04.service.ExaminationService;

import java.util.Locale;

@ShellComponent
public class ShellCommands {

    private AppProperties props;
    private ExaminationService examinationService;

    @Autowired
    public ShellCommands(AppProperties props, ExaminationService examinationService) {
        this.props = props;
        this.examinationService = examinationService;
    }

    @ShellMethod("Set the user locale")
    public void setLocale(@ShellOption({"-l", "--language-code"}) String languageCode,
                          @ShellOption({"-c", "--country-code"}) String countryCode) {
        props.setUserLocale(new Locale(languageCode, countryCode));
    }

    @ShellMethod(value = "Start the examination", key = {"start", "start-examination"})
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
