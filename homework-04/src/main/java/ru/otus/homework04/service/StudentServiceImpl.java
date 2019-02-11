package ru.otus.homework04.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.homework04.domain.Student;

@Service
public class StudentServiceImpl implements StudentService {

    private final ConsoleService consoleService;
    private Student student;

    @Autowired
    public StudentServiceImpl(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    @Override
    public void getStudentInfo() {
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
        this.student = new Student(name, surname);
    }

    @Override
    public Student getStudent() {
        return student;
    }
}
