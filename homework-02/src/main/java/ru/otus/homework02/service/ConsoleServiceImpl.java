package ru.otus.homework02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Scanner;
@Service
public class ConsoleServiceImpl implements ConsoleService {

    private final MessageSource messageSource;

    private final Locale userLocale;

    private final Scanner scanner;

    @Autowired
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
    public void writeLocalizedMessage(String message, Object[] parameters) {
        writeMessage(messageSource.getMessage(message, parameters, userLocale));
    }

    @Override
    public String readMessage() {
        return scanner.nextLine();
    }



}
