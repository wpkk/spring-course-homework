package ru.otus.homework06.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.otus.homework06.dao.AuthorDaoJpa;
import ru.otus.homework06.dao.BookDaoJpa;
import ru.otus.homework06.dao.GenreDaoJpa;
import ru.otus.homework06.domain.Book;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
@Import({DatabaseServiceImpl.class, BookDaoJpa.class, AuthorDaoJpa.class, GenreDaoJpa.class})
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