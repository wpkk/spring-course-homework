package ru.otus.homework07.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import ru.otus.homework07.domain.Author;
import ru.otus.homework07.domain.Book;
import ru.otus.homework07.repository.AuthorRepository;
import ru.otus.homework07.repository.BookRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@DataJpaTest
@Import({DatabaseServiceImpl.class})
@DisplayName("Class DatabaseServiceImpl")
class DatabaseServiceImplTest {

    private static final String AUTHOR_SURNAME = "author1";
    private static final int EXPECTED_NUMBER_OF_BOOKS = 2;
    private static final long AUTHOR_ID = 1L;

    @Autowired
    private DatabaseService databaseService;

    @MockBean
    private BookRepository bookRepository;

    @MockBean
    private AuthorRepository authorRepository;

    @Mock
    private Author author;

    @Mock
    private Book book;

    @Test
    @DisplayName("Should return books by specific author")
    void shouldReturnBooksBySpecificAuthor() {
        when(book.getAuthor()).thenReturn(author);
        when(author.getId()).thenReturn(AUTHOR_ID);
        when(authorRepository.getBySurname(AUTHOR_SURNAME)).thenReturn(author);
        when(bookRepository.getByAuthor(any(Author.class))).thenReturn(List.of(book, book));

        List<Book> books = databaseService.getBooksByAuthor(AUTHOR_SURNAME);
        assertThat(books).hasSize(EXPECTED_NUMBER_OF_BOOKS).allMatch(b -> b.getAuthor().getId() == AUTHOR_ID);

    }
}