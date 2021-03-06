package ru.otus.homework01.service;

import ru.otus.homework01.domain.Student;

public class StudentServiceImpl implements StudentService {

    private final ConsoleService consoleService;

    public StudentServiceImpl(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    @Override
    public Student getStudentInfo() {
        consoleService.writeMessage("Enter your name:");
        String name = consoleService.readMessage();
        while (name.equals("")) {
            consoleService.writeMessage("The name should not be empty");
            name = consoleService.readMessage();
        }
        consoleService.writeMessage("Enter your surname:");
        String surname = consoleService.readMessage();
        while (surname.equals("")) {
            consoleService.writeMessage("The surname should not be empty");
            surname = consoleService.readMessage();
        }
        return new Student(name, surname);
    }
}
