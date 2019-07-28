package ru.otus.homework05.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;

@SpringBootTest
@DisplayName("Class LibraryServiceImpl")
class LibraryServiceImplTest {

    @MockBean
    private ConsoleService consoleService;

    @Autowired
    private LibraryService libraryService;

    private static final String ALL_TITLES = "title1, title2, title3";

    @Test
    @DisplayName("Should print all books")
    void shouldPrintAllBooks() {

        libraryService.getAllBooks();
        verify(consoleService, times(1)).writeMessage(ALL_TITLES);
    }




}