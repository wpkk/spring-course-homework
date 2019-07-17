package ru.otus.homework05.dao;

import ru.otus.homework05.domain.Book;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class BookDaoJdbc implements BookDao {

    private final NamedParameterJdbcOperations jdbcOperations;

    public BookDaoJdbc(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public int count() {
        return jdbcOperations.queryForObject("select count(*) from books", new HashMap<>(), Integer.class);
    }

    @Override
    public Book getById(int id) {
        return null;
    }

    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public List<Book> getByAuthor(String author) {
        return null;
    }

    @Override
    public List<Book> getByGenre(String genre) {
        return null;
    }

    @Override
    public int insert(Book book) {
        return 0;
    }

    @Override
    public int deleteById(Book book) {
        return 0;
    }
}
