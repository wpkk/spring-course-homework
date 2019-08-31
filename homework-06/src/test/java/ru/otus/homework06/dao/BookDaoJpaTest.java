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

    private final static long BOOK_ID = 2L;
    private final static int BOOK_COUNT = 3;
    private final static int AUTHOR_ID = 1;
    private final static int BOOKS_FOR_AUTHOR_ONE = 2;
    private final static Year YEAR_BIRTH = Year.of(1970);
    private final static Year YEAR_DEATH = Year.of(2000);


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
        assertEquals(BOOK_COUNT, bookDao.count());
    }

    @Test
    @DisplayName("Should get correct book by id")
    void shouldGetCorrectBookById() {
        Optional<Book> actualBook = bookDao.getById(BOOK_ID);
        Book expectedBook = em.find(Book.class, BOOK_ID);
        assertThat(actualBook).isPresent().get().isEqualToComparingFieldByField(expectedBook);
    }

    @Test
    @DisplayName("Should return all the books")
    void shouldReturnAllTheBooks() {
        List<Book> books = bookDao.getAll();
        assertThat(books).hasSize(BOOK_COUNT);
    }

    @Test
    @DisplayName("Should return books by specific author")
    void shouldReturnBooksBySpecificAuthor() {
        Author author = new Author(AUTHOR_ID, "name1", "author1", YEAR_BIRTH, YEAR_DEATH);
        List<Book> books = bookDao.getByAuthor(author);
        assertThat(books).hasSize(BOOKS_FOR_AUTHOR_ONE).allMatch(b -> b.getAuthor().getId() == AUTHOR_ID &&
                b.getAuthor().getBirth().equals(YEAR_BIRTH) &&
                b.getAuthor().getDeath().equals(YEAR_DEATH));
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