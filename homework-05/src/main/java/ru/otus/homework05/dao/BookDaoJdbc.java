package ru.otus.homework05.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import ru.otus.homework05.domain.Book;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
@SuppressWarnings({"ConstantConditions"})

@Repository
public class BookDaoJdbc implements BookDao {

    private final NamedParameterJdbcOperations jdbcOperations;

    private final RowMapper<Book> bookMapper;

    public BookDaoJdbc(NamedParameterJdbcOperations jdbcOperations, RowMapper<Book> bookMapper) {
        this.jdbcOperations = jdbcOperations;
        this.bookMapper = bookMapper;
    }

    @Override
    public int count() {
        SqlParameterSource parameterSource = new EmptySqlParameterSource();
        return jdbcOperations.queryForObject("select count(*) from books", parameterSource, Integer.class);
    }

    @Override
    public Book getById(int id) {
        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("id", id);
        return jdbcOperations.queryForObject("select * from books where id = :id", parameterSource, bookMapper);
    }

    @Override
    public List<Book> getAll() {
        return jdbcOperations.query("select * from books", bookMapper);
    }

    @Override
    public List<Book> getByAuthor(String author) {
        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("surname", author);
        return jdbcOperations.query("select * from books where author_id in " +
                "(select id from authors where surname = :surname)", parameterSource, bookMapper);
    }

    @Override
    public List<Book> getByGenre(String genre) {
        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("genre", genre);
        return jdbcOperations.query("select * from books where genre_id in " +
                "(select id from genres where genre = :genre)", parameterSource, bookMapper);    }

    @Override
    public int insert(Book book) {
        SqlParameterSource parameterSource = new MapSqlParameterSource().
                addValue("id", book.getId()).
                addValue("title", book.getTitle()).
                addValue("authorId", book.getAuthorId()).
                addValue("genreId", book.getGenreId());

        return jdbcOperations.update("insert into books values (:id, :title, :authorId, :genreId)", parameterSource);
    }

    @Override
    public int deleteById(Book book) {
        return 0;
    }
}
