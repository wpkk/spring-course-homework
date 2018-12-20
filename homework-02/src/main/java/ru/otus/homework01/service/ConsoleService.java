package ru.otus.homework01.service;

public interface ConsoleService {

    void writeMessage(String message);

    void writeLocalizedMessage(String message);

    void writeLocalizedMessage(String message, Object[] parameters);

    String readMessage();
}
