package ru.otus.homework05.dao;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.otus.homework05.dao.mappers.GenreMapper;
import ru.otus.homework05.domain.Book;
import ru.otus.homework05.domain.Genre;

import java.util.List;

@SuppressWarnings("ConstantConditions")
@Repository @AllArgsConstructor
public class GenreDaoJdbc implements GenreDao {

    private final NamedParameterJdbcOperations jdbcOperations;
    private final GenreMapper genreMapper;

    @Override
    public int count() {
        return jdbcOperations.queryForObject("select count(*) from genres", new EmptySqlParameterSource(), Integer.class);
    }

    @Override
    public Genre getById(int id) {
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        return jdbcOperations.queryForObject("select * from genres where id = :id", parameterSource, genreMapper);
    }

    @Override
    public Genre getByGenre(String genre) {
        SqlParameterSource parameterSource = new MapSqlParameterSource("genre", genre);
        return jdbcOperations.queryForObject("select * from genres where genre = :genre", parameterSource, genreMapper);
    }

    @Override
    public Genre getByBook(Book book) {
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", book.getId());
        return jdbcOperations.queryForObject("select * from genres g where g.id in (select genre_id from books b where b.id = :id)", parameterSource, genreMapper);
    }

    @Override
    public List<Genre> getAll() {
        return jdbcOperations.query("select * from genres", new EmptySqlParameterSource(), genreMapper);
    }

    @Override
    public int insert(Genre genre) {
        SqlParameterSource parameterSource = new MapSqlParameterSource("genre", genre.getGenre());
        return jdbcOperations.update("insert into genres values(default, :genre)", parameterSource);
    }

    @Override
    public int deleteById(int id) {
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        return jdbcOperations.update("delete from genres where id = :id", parameterSource);
    }

}
