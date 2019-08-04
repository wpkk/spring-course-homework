package ru.otus.homework06.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.otus.homework06.dao.AuthorDaoJdbc;
import ru.otus.homework06.dao.BookDaoJdbc;
import ru.otus.homework06.dao.GenreDaoJdbc;
import ru.otus.homework06.dao.mappers.AuthorMapper;
import ru.otus.homework06.dao.mappers.BookMapper;
import ru.otus.homework06.dao.mappers.GenreMapper;
import ru.otus.homework06.domain.Book;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
@Import({DatabaseServiceImpl.class, BookDaoJdbc.class, BookMapper.class, AuthorDaoJdbc.class, AuthorMapper.class, GenreDaoJdbc.class, GenreMapper.class})
@DisplayName("Class DatabaseServiceImpl")
class DatabaseServiceImplTest {

  @Autowired
  private DatabaseService databaseService;

  static private final String AUTHOR_SURNAME = "author1";
  @Test
  @DisplayName("Should return books by specific author")
  void shouldReturnBooksBySpecificAuthor() {
      List<Book> books = databaseService.getBooksByAuthor(AUTHOR_SURNAME);
      assertThat(books).hasSize(2).allMatch(b -> b.getAuthor().getId() == 1);

  }


}