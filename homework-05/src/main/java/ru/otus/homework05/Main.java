package ru.otus.homework05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.h2.tools.Console;
import ru.otus.homework05.dao.BookDao;
import ru.otus.homework05.domain.Book;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws Exception{
        ApplicationContext context = SpringApplication.run(Main.class);

        BookDao dao = context.getBean(BookDao.class);

        System.out.println(dao.getByAuthor("author1"));

        System.out.println(dao.getByGenre("genre3"));

        Book book = new Book(5, "Kruzka", 2, 2);

        dao.insert(book);

        System.out.println(dao.getAll());

        Console.main(args);
    }

}
