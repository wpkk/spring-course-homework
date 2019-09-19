package ru.otus.homework07.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.assertj.core.api.Assertions.assertThat;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import ru.otus.homework07.domain.Author;
import ru.otus.homework07.domain.Book;

import java.time.Year;

@DataJpaTest
@DisplayName("Author repository")
class AuthorRepositoryTest {

    private final static long AUTHOR_ID = 1L;
    private static final long DEFAULT_AUTHOR_ID = 0L;
    private static final String EXPECTED_NAME = "name1";
    private final static Year YEAR_BIRTH = Year.of(1970);
    private final static Year YEAR_DEATH = Year.of(2000);
    private final static String TEST_AUTHOR_NAME = "testName";

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private TestEntityManager em;

    @Mock
    Book book;

    @Mock
    Author author;

    @Test
    @DisplayName("Should return author by specific book")
    void shouldReturnAuthorBySpecificBook() {
        Mockito.when(book.getAuthor()).thenReturn(author);
        Mockito.when(author.getId()).thenReturn(AUTHOR_ID);
        Author author = authorRepository.getByBook(book).orElseThrow();
        assertThat(author.getName()).isEqualTo(EXPECTED_NAME);
    }

    @Test
    @DisplayName("Should correctly save author")
    void shouldCorrectlySaveAuthor() {
        Author expectedAuthor = new Author(DEFAULT_AUTHOR_ID, TEST_AUTHOR_NAME, TEST_AUTHOR_NAME, YEAR_BIRTH, YEAR_DEATH);
        Author persistedAuthor = em.persist(expectedAuthor);
        Author realAuthor = authorRepository.findById(persistedAuthor.getId()).orElseThrow();
        assertThat(realAuthor).isEqualToComparingFieldByField(expectedAuthor);
    }
}