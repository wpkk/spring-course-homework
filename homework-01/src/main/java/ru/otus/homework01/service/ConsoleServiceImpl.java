package ru.otus.homework01.service;

import java.io.Console;

public class ConsoleServiceImpl implements ConsoleService {

//    private Console console = System.console();
    private Console console;

    public ConsoleServiceImpl(Console console) {
        this.console = console;
    }

    @Override
    public void writeMessage(String message) {
        console.printf(message);
    }

    @Override
    public String readMessage() {
        return console.readLine();
    }
}
