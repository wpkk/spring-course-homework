package ru.otus.homework05.dao.mappers;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import ru.otus.homework05.dao.AuthorDao;
import ru.otus.homework05.dao.GenreDao;
import ru.otus.homework05.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service @AllArgsConstructor
public class BookMapper implements RowMapper<Book> {

    private  final AuthorDao authorDao;

    private final GenreDao genreDao;

    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("id");
        String title = resultSet.getString("title");
        int authorId = resultSet.getInt("author_id");
        int genreId = resultSet.getInt("genre_id");
        return new Book(id, title, authorDao.getById(authorId), genreDao.getById(genreId));
    }
}
