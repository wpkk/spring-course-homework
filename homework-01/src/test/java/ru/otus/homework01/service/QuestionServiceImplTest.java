package ru.otus.homework01.service;

import org.junit.Test;
import org.mockito.Mock;
import ru.otus.homework01.dao.QuestionDao;
import ru.otus.homework01.domain.Question;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class QuestionServiceImplTest {

    private ConsoleService consoleService = mock(ConsoleService.class);

    private QuestionDao questionDao = mock(QuestionDao.class);

    @Test
    public void testGetQuestions() {
        when(questionDao.getQuestions()).thenReturn(new ArrayList<>());
        QuestionService questionService = new QuestionServiceImpl(questionDao, consoleService);
        questionService.getQuestions();
        verify(questionDao, times(1)).getQuestions();
    }

    @Test
    public void askQuestions() {


    }
}