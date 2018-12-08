package ru.otus.homework01.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.homework01.dao.QuestionDao;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Class QuestionServiceImpl")
public class QuestionServiceImplTest {
    @Mock
    private ConsoleService consoleService;
    @Mock
    private QuestionDao questionDao;

    @Test
    @DisplayName("Calls dao only once")
    public void testGetQuestions() {
        QuestionService questionService = new QuestionServiceImpl(questionDao, consoleService);
        questionService.getQuestions();
        verify(questionDao, times(1)).getQuestions();
    }

    @Test
    public void askQuestions() {


    }
}