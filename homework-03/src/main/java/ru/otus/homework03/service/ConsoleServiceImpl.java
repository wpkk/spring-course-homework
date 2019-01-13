package ru.otus.homework03.service;

import org.springframework.context.MessageSource;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleServiceImpl implements ConsoleService {

    private final MessageSource messageSource;

    private final Locale userLocale;

    private final Scanner scanner;

    public ConsoleServiceImpl(MessageSource messageSource, Locale userLocale) {
        scanner = new Scanner(System.in);
        this.messageSource = messageSource;
        this.userLocale = userLocale;
    }

    @Override
    public void writeMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void writeLocalizedMessage(String message) {
        writeLocalizedMessage(message, null);
    }

    @Override
    public void writeLocalizedMessage(String message, Object... parameters) {
        writeMessage(messageSource.getMessage(message, parameters, userLocale));
    }

    @Override
    public String readMessage() {
        return scanner.nextLine();
    }



}
