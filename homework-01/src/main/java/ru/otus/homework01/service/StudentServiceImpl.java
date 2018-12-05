package ru.otus.homework01.service;

import ru.otus.homework01.domain.Student;

public class StudentServiceImpl implements StudentService {

    private ConsoleService consoleService;
    private String name;
    private String surname;

    public StudentServiceImpl(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    @Override
    public Student getStudentInfo() {
        consoleService.writeMessage("Enter your name");
        name = consoleService.readMessage();
        consoleService.writeMessage("Enter your surname");
        surname = consoleService.readMessage();
        return new Student(name, surname);
    }
}
