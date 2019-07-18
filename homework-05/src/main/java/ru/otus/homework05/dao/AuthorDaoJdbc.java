package ru.otus.homework05.dao;

import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.otus.homework05.dao.mappers.AuthorMapper;
import ru.otus.homework05.domain.Author;
import ru.otus.homework05.domain.Book;

import java.util.List;

@SuppressWarnings({"ConstantConditions"})
@Repository
public class AuthorDaoJdbc implements AuthorDao {

    private final NamedParameterJdbcOperations jdbcOperations;

    private final AuthorMapper authorMapper;

    public AuthorDaoJdbc(NamedParameterJdbcOperations jdbcOperations, AuthorMapper authorMapper) {
        this.jdbcOperations = jdbcOperations;
        this.authorMapper = authorMapper;
    }

    @Override
    public int count() {
        return jdbcOperations.queryForObject("select count(*) from authors", new EmptySqlParameterSource(), Integer.class);
    }

    @Override
    public Author getById(int id) {
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        return jdbcOperations.queryForObject("select * from authors where id = :id", parameterSource, authorMapper);
    }

    @Override
    public Author getByBook(Book book) {
        SqlParameterSource parameterSource = new MapSqlParameterSource("bookId", book.getId());
        return jdbcOperations.queryForObject("select * from authors a where a.id in (select author_id from books b where b.id = :bookId)", parameterSource, authorMapper);
    }

    @Override
    public List<Author> getAll() {
        return jdbcOperations.query("select * from authors", new EmptySqlParameterSource(), authorMapper);
    }

    @Override
    public int insert(Author author) {
        SqlParameterSource parameterSource = new MapSqlParameterSource().
                addValue("id", author.getId()).
                addValue("name", author.getName()).
                addValue("surname", author.getSurname()).
                addValue("birth", author.getBirth()).
                addValue("death", author.getDeath());
        return jdbcOperations.update("insert into authors values(:id, :name, :surname, :birth, :death)", parameterSource);
    }

    @Override
    public int deleteById(int id) {
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        return jdbcOperations.update("delete from authors where id = :id", parameterSource);
    }
}
