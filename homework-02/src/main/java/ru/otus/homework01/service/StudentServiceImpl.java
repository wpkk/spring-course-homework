package ru.otus.homework01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.homework01.domain.Student;

@Service
public class StudentServiceImpl implements StudentService {

    private final ConsoleService consoleService;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    public StudentServiceImpl(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    @Override
    public Student getStudentInfo() {
        consoleService.writeLocalizedMessage("message.enterName");
        String name = consoleService.readMessage();
        while (name.equals("")) {
            consoleService.writeLocalizedMessage("message.emptyName");
            name = consoleService.readMessage();
        }
        consoleService.writeLocalizedMessage("message.enterSurname");
        String surname = consoleService.readMessage();
        while (surname.equals("")) {
            consoleService.writeLocalizedMessage("message.emptySurname");
            surname = consoleService.readMessage();
        }
        return new Student(name, surname);
    }
}
