package ru.otus.homework05.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.homework05.AppProperties;

import java.util.Scanner;

@Service
public class ConsoleServiceImpl implements ConsoleService {

    private final MessageSource messageSource;

    private final Scanner scanner;

    private final AppProperties props;

    public ConsoleServiceImpl(MessageSource messageSource, AppProperties props) {
        scanner = new Scanner(System.in);
        this.messageSource = messageSource;
        this.props = props;
    }

    @Override
    public void writeMessage(String message) {
        System.out.println(message);
    }

    @Override
    public <T> void writeMessage(T type) {
        System.out.println(type.toString());
    }

    @Override
    public void writeLocalizedMessage(String message) {
        writeLocalizedMessage(message, null);
    }

    @Override
    public void writeLocalizedMessage(String message, Object... parameters) {
        writeMessage(messageSource.getMessage(message, parameters, props.getUserLocale()));
    }

    @Override
    public String readMessage() {
        return scanner.nextLine();
    }
}