package ru.otus.homework05.dao;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import ru.otus.homework05.domain.Author;
import ru.otus.homework05.domain.Book;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.homework05.domain.Genre;

import java.util.List;
@SuppressWarnings("ConstantConditions")

@Repository @AllArgsConstructor
public class BookDaoJdbc implements BookDao {

    private final NamedParameterJdbcOperations jdbcOperations;

    private final RowMapper<Book> bookMapper;

    @Override
    public int count() {
        SqlParameterSource parameterSource = new EmptySqlParameterSource();
        return jdbcOperations.queryForObject("select count(*) from books", parameterSource, Integer.class);
    }

    @Override
    public Book getById(int id) {
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        return jdbcOperations.queryForObject("select * from BOOKS b inner join AUTHORS a on b.AUTHOR_ID = a.ID inner join GENRES g on b.GENRE_ID = g.ID where b.ID = :id", parameterSource, bookMapper);
    }

    @Override
    public Book getByTitle(String title) {
        SqlParameterSource parameterSource = new MapSqlParameterSource("title", title);
        return jdbcOperations.queryForObject("select * from BOOKS b inner join AUTHORS a on b.AUTHOR_ID = a.ID inner join GENRES g on b.GENRE_ID = g.ID where b.TITLE = :title", parameterSource, bookMapper);
    }

    @Override
    public List<Book> getAll() {
        return jdbcOperations.query("select * from BOOKS b inner join AUTHORS a on b.AUTHOR_ID = a.ID inner join GENRES g on b.GENRE_ID = g.ID", bookMapper);
    }

    @Override
    public List<Book> getByAuthor(Author author) {
        SqlParameterSource parameterSource = new MapSqlParameterSource("surname", author.getSurname());
        return jdbcOperations.query("select * from BOOKS b inner join AUTHORS a on b.AUTHOR_ID = a.ID inner join GENRES g on b.GENRE_ID = g.ID where a.SURNAME = :surname", parameterSource, bookMapper);
    }

    @Override
    public List<Book> getByGenre(Genre genre) {
        SqlParameterSource parameterSource = new MapSqlParameterSource("genre", genre.getGenre());
        return jdbcOperations.query("select * from BOOKS b inner join AUTHORS a on b.AUTHOR_ID = a.ID inner join GENRES g on b.GENRE_ID = g.ID where g.GENRE = :genre", parameterSource, bookMapper);
    }

    @Override
    public int insert(Book book) {
        SqlParameterSource parameterSource = new MapSqlParameterSource().
                addValue("title", book.getTitle()).
                addValue("authorId", book.getAuthor().getId()).
                addValue("genreId", book.getGenre().getId());

        return jdbcOperations.update("insert into books values (default, :title, :authorId, :genreId)", parameterSource);
    }

    @Override
    public int deleteById(int id) {
        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("id", id);
        return jdbcOperations.update("delete from books where id = :id", parameterSource);
    }
}
