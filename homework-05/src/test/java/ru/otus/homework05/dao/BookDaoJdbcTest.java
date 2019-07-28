package ru.otus.homework05.dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.otus.homework05.dao.mappers.AuthorMapper;
import ru.otus.homework05.dao.mappers.BookMapper;
import ru.otus.homework05.dao.mappers.GenreMapper;
import ru.otus.homework05.domain.Author;
import ru.otus.homework05.domain.Book;

import java.time.Year;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
@Import({BookDaoJdbc.class, BookMapper.class, AuthorDaoJdbc.class, AuthorMapper.class, GenreDaoJdbc.class, GenreMapper.class})
@DisplayName("Class BookDaoJdbc")
class BookDaoJdbcTest {

    @Autowired
    private BookDao bookDao;

    @Test
    @DisplayName("Should return correct number of books")
    void shouldReturnCorrectNumberOfBooks() {
        assertEquals(3, bookDao.count());
    }

    @Test
    @DisplayName("Should get correct book by id")
    void shouldGetCorrectBookById() {
        Book book = bookDao.getById(2);
        assertThat(book.getId()).isEqualTo(2);
    }

    @Test
    @DisplayName("Should return all the books")
    void shouldReturnAllTheBooks() {
        List<Book> books = bookDao.getAll();
        assertThat(books).hasSize(3);
    }

    @Test
    @DisplayName("Should return books by specific author")
    void shouldReturnBooksBySpecificAuthor() {
        Author author = new Author(1, "name1", "author1", Year.of(1970), Year.of(2000));
        List<Book> books = bookDao.getByAuthor(author);
        assertThat(books).hasSize(2).allMatch(b -> b.getAuthor().getId() == 1);
    }
}