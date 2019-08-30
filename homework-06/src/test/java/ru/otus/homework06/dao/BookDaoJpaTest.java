package ru.otus.homework06.dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.homework06.domain.Author;
import ru.otus.homework06.domain.Book;
import ru.otus.homework06.domain.Genre;

import java.time.Year;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import({BookDaoJpa.class, AuthorDaoJpa.class, GenreDaoJpa.class})
@DisplayName("Class BookDaoJdbc")
class BookDaoJpaTest {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private TestEntityManager em;

    @Mock
    private Genre genre;

    @Mock
    private Author author;

    @Test
    @DisplayName("Should return correct number of books")
    void shouldReturnCorrectNumberOfBooks() {
        assertEquals(3, bookDao.count());
    }

    @Test
    @DisplayName("Should get correct book by id")
    void shouldGetCorrectBookById() {
        Optional<Book> actualBook = bookDao.getById(2L);
        Book expectedBook = em.find(Book.class, 2L);
        assertThat(actualBook).isPresent().get().isEqualToComparingFieldByField(expectedBook);
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

    @Test
    @DisplayName("Should correctly persist books")
    void shouldCorrectlyPersistBooks() {

        Book book = new Book(0, "test", author, genre);
        bookDao.insert(book);
        System.out.println(book.getId());
        assertThat(book.getId()).isGreaterThan(0);

        Mockito.when(author.getName()).thenReturn("test_name");

        Book actualBook = em.find(Book.class, book.getId());
        assertThat(actualBook).isNotNull().matches(b -> !b.getTitle().equals(""))
                .matches(b -> b.getAuthor() != null && b.getAuthor().getName().equals("test_name"))
                .matches(b -> b.getGenre() != null);
    }
}