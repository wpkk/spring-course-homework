package ru.otus.homework07.service;

public interface ConsoleService {

    void writeMessage(String message);

    <T> void writeMessage(T type);

    void writeLocalizedMessage(String message);

    void writeLocalizedMessage(String message, Object... parameters);

    String readMessage();

}
