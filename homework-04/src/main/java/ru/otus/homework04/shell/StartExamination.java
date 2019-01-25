package ru.otus.homework04.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.homework04.service.ExaminationService;

@ShellComponent
public class StartExamination {

    private ExaminationService examinationService;

    @Autowired
    public StartExamination(ExaminationService examinationService) {
        this.examinationService = examinationService;
    }

    @ShellMethod("Starts the examination")
    public void startExamination() {
        examinationService.startExamination();
    }
}
