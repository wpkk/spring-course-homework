package ru.otus.homework05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.h2.tools.Console;

@SpringBootApplication
//@EnableConfigurationProperties(AppProperties.class)

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class);

//        Console.main(args);
    }

}
