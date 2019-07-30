package ru.otus.homework05.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import ru.otus.homework05.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class GenreMapper implements RowMapper<Genre> {

    @Override
    public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("id");
        String genre = resultSet.getString("genre");

        return new Genre(id, genre);
    }
}
