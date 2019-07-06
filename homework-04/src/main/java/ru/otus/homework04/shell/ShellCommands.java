package ru.otus.homework04.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.Availability;
import org.springframework.shell.ExitRequest;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.homework04.AppProperties;
import ru.otus.homework04.service.ConsoleService;
import ru.otus.homework04.service.EvaluationService;
import ru.otus.homework04.service.ExaminationService;

import java.util.Locale;

@ShellComponent
public class ShellCommands {

    private AppProperties props;
    private ExaminationService examinationService;
    private EvaluationService evaluationService;
    private boolean finished;

    @Autowired
    public ShellCommands(AppProperties props, ExaminationService examinationService, EvaluationService evaluationService) {
        this.props = props;
        this.examinationService = examinationService;
        this.evaluationService = evaluationService;
    }

    @ShellMethod("Set the user locale")
    public void setLocale(@ShellOption({"-l", "--language-code"}) String languageCode,
                          @ShellOption({"-c", "--country-code"}) String countryCode) {
        props.setUserLocale(new Locale(languageCode, countryCode));
    }

    @ShellMethod(value = "Start the examination", key = {"start", "start-examination"})
    public void startExamination() {
        examinationService.startExamination();
        finished = true;
    }

    @ShellMethod(value = "Evaluates the student based on last examination's results", key = {"eval", "evaluate-student"})
    public void evaluateStudent() {
        evaluationService.evaluateLastStudent();
    }

    public Availability evaluateStudentAvailability() {
        return finished
                ? Availability.available()
                : Availability.unavailable("the examination wasn't finished");
    }

}

@ShellComponent
class Quit implements org.springframework.shell.standard.commands.Quit.Command {
    private ConsoleService consoleService;

    @Autowired
    public Quit(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    @ShellMethod(value = "Exit the shell", key = {"quit", "exit"})
    public void quit() {
        consoleService.writeLocalizedMessage("message.quit");
        throw new ExitRequest();
    }

}
