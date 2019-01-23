package ru.otus.homework03.service;

public interface ConsoleService {

    void writeMessage(String message);

    void writeLocalizedMessage(String message);

    void writeLocalizedMessage(String message, Object... parameters);

    String readMessage();
}
