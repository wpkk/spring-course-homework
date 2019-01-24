package ru.otus.homework04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import ru.otus.homework04.service.ExaminationService;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }

}
