package ru.otus.homework05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.h2.tools.Console;
import ru.otus.homework05.dao.AuthorDao;
import ru.otus.homework05.dao.BookDao;
import ru.otus.homework05.domain.Book;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws Exception{
        ApplicationContext context = SpringApplication.run(Main.class);

        BookDao bookDaoDao = context.getBean(BookDao.class);
        AuthorDao authorDao = context.getBean(AuthorDao.class);

        Book book = bookDaoDao.getById(1);

        System.out.println(authorDao.getByBook(book));

        Console.main(args);
    }

}
