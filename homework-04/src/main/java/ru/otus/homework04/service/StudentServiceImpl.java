package ru.otus.homework04.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.homework04.domain.Student;

@Service
public class StudentServiceImpl implements StudentService {

    private final ConsoleService consoleService;
    @Getter
    private Student student;
    private static final String MESSAGE_ENTER_NAME = "message.enterName";
    private static final String MESSAGE_EMPTY_NAME = "message.emptyName";
    private static final String MESSAGE_ENTER_SURNAME = "message.enterSurname";
    private static final String MESSAGE_EMPTY_SURNAME = "message.emptySurname";

    @Autowired
    public StudentServiceImpl(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    @Override
    public void getStudentInfo() {
        consoleService.writeLocalizedMessage(MESSAGE_ENTER_NAME);
        String name = consoleService.readMessage();
        while (name.equals("")) {
            consoleService.writeLocalizedMessage(MESSAGE_EMPTY_NAME);
            name = consoleService.readMessage();
        }
        consoleService.writeLocalizedMessage(MESSAGE_ENTER_SURNAME);
        String surname = consoleService.readMessage();
        while (surname.equals("")) {
            consoleService.writeLocalizedMessage(MESSAGE_EMPTY_SURNAME);
            surname = consoleService.readMessage();
        }
        this.student = new Student(name, surname);
    }

}
