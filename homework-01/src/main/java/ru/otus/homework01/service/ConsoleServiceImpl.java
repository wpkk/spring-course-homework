package ru.otus.homework01.service;

import java.util.Scanner;

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
