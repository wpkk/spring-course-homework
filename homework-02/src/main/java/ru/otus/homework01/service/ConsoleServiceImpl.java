package ru.otus.homework01.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;
@Service
public class ConsoleServiceImpl implements ConsoleService {

    private final Scanner scanner;

    public ConsoleServiceImpl() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void writeMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String readMessage() {
        return scanner.nextLine();
    }
}
