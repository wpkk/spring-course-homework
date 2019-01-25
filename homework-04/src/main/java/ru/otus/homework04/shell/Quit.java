package ru.otus.homework04.shell;

import org.springframework.shell.ExitRequest;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class Quit implements org.springframework.shell.standard.commands.Quit.Command {

    @ShellMethod(value = "Exit the shell", key = {"quit", "exit"})
    public void quit() {
        System.out.println("Thank you for using the examination application!");
        throw new ExitRequest();
    }

}
