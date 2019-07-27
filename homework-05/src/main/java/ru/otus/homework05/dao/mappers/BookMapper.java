package ru.otus.homework05.dao.mappers;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import ru.otus.homework05.dao.AuthorDao;
import ru.otus.homework05.dao.GenreDao;
import ru.otus.homework05.domain.Author;
import ru.otus.homework05.domain.Book;
import ru.otus.homework05.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;

@Service @AllArgsConstructor
public class BookMapper implements RowMapper<Book> {

    private  final AuthorDao authorDao;

    private final GenreDao genreDao;

    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("id");
        String title = resultSet.getString("title");
        int authorId = resultSet.getInt("author_id");
        String name = resultSet.getString("name");
        String surname = resultSet.getString("surname");
        int birthYear = resultSet.getInt("year_birth");
        int deathYear = resultSet.getInt("year_death");
        int genreId = resultSet.getInt("genre_id");
        String genre = resultSet.getString("genre");
        return new Book(id, title, new Author(authorId, name, surname, Year.of(birthYear), Year.of(deathYear)), new Genre(genreId, genre));
    }
}
