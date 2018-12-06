package ru.otus.homework01.service;

import ru.otus.homework01.domain.Student;

public class StudentServiceImpl implements StudentService {

    private final ConsoleService consoleService;

    public StudentServiceImpl(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    @Override
    public Student getStudentInfo() {
        consoleService.writeMessage("Enter your name");
        String name = consoleService.readMessage();
        consoleService.writeMessage("Enter your surname");
        String surname = consoleService.readMessage();
        return new Student(name, surname);
    }
}
