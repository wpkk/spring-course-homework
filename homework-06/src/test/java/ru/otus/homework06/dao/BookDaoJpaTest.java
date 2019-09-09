package ru.otus.homework06.dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;
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
import static org.mockito.Mockito.*;

@DataJpaTest
@Import({BookDaoJpa.class, AuthorDaoJpa.class, GenreDaoJpa.class})
@DisplayName("Class BookDaoJdbc")
class BookDaoJpaTest {

    private final static long BOOK_ID = 2L;
    private final static long DEFAULT_BOOK_ID = 0L;
    private final static int BOOK_COUNT = 3;
    private final static long AUTHOR_ID = 1;
    private final static int BOOKS_FOR_AUTHOR_ONE = 2;
    private final static Year YEAR_BIRTH = Year.of(1970);
    private final static Year YEAR_DEATH = Year.of(2000);
    private final static String TEST_AUTHOR_NAME = "testName";
    private final static String TEST_BOOK_TITLE = "testTitle";

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
        when(author.getId()).thenReturn(AUTHOR_ID);
        List<Book> books = bookDao.getByAuthor(author);
        assertThat(books).hasSize(BOOKS_FOR_AUTHOR_ONE).allMatch(b -> b.getAuthor().getId() == AUTHOR_ID &&
                b.getAuthor().getBirth().equals(YEAR_BIRTH) &&
                b.getAuthor().getDeath().equals(YEAR_DEATH));
    }

    @Test
    @DisplayName("Should correctly persist books")
    void shouldCorrectlyPersistBooks() {

        Book book = new Book(DEFAULT_BOOK_ID, TEST_BOOK_TITLE, author, genre);
        bookDao.insert(book);
        assertThat(book.getId()).isGreaterThan(DEFAULT_BOOK_ID);

        when(author.getName()).thenReturn(TEST_AUTHOR_NAME);

        Book actualBook = em.find(Book.class, book.getId());
        assertThat(actualBook).isNotNull().matches(b -> !b.getTitle().equals(""))
                .matches(b -> b.getAuthor() != null && b.getAuthor().getName().equals(TEST_AUTHOR_NAME))
                .matches(b -> b.getGenre() != null);
    }
}