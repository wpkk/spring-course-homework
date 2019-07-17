package ru.otus.homework05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.homework05.dao.BookDao;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class);

        BookDao dao = context.getBean(BookDao.class);

        System.out.println(dao.count());

    }

}
