package ru.otus.homework05.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import ru.otus.homework05.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("id");
        String title = resultSet.getString("title");
        int authorId = resultSet.getInt("author_id");
        int genreId = resultSet.getInt("genre_id");
        return new Book(id, title, authorId, genreId);
    }

    public BookMapper createBean() {
        return new BookMapper();
    }

}
