package ru.otus.homework05.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import ru.otus.homework05.domain.Author;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;

@Service
public class AuthorMapper implements RowMapper<Author> {

    @Override
    public Author mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String surname = resultSet.getString("surname");
        Year birth = Year.of(resultSet.getInt("year_birth"));
        Year death = Year.of(resultSet.getInt("year_death"));
        return new Author(id, name, surname, birth, death);
    }
}
