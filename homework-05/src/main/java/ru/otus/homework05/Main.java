package ru.otus.homework05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.h2.tools.Console;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws Exception{
        ApplicationContext context = SpringApplication.run(Main.class);

//        Console.main(args);
    }

}
