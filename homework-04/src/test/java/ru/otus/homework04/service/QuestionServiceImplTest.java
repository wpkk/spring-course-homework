package ru.otus.homework04.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.otus.homework04.dao.QuestionDao;
import ru.otus.homework04.domain.Answer;
import ru.otus.homework04.domain.Question;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Java6Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
@DisplayName("Class QuestionServiceImpl")
class QuestionServiceImplTest {
    @MockBean
    private ConsoleService consoleService;
    @MockBean
    private QuestionDao questionDao;
    @Autowired
    private QuestionService questionService;
    @Mock
    private Answer correctAnswer;
    @Mock
    private Answer incorrectAnswer;
    @Mock
    private Question question;

    @Test
    @DisplayName("Method askQuestions correctly sets fields of questions")
        void testAskQuestions() {

        doCallRealMethod().when(question).setAnsweredCorrectly(anyBoolean());

        List<Question> questions = Arrays.asList(question, question);

        when(questionDao.getQuestions()).thenReturn(questions);
        when(consoleService.readMessage()).thenReturn("2");

        when(correctAnswer.isCorrect()).thenReturn(true);
        List<Answer> answers = Arrays.asList(incorrectAnswer, correctAnswer, incorrectAnswer);
        when(question.shuffleAnswers()).thenReturn(answers);

        questionService.askQuestions();

        verify(question, times(2)).setAnsweredCorrectly(true);
        assertThat(question).hasFieldOrPropertyWithValue("isAnsweredCorrectly", true);
    }

    @Test
    @DisplayName("Method askQuestion() returns the number of the correct answer")
    void testAskQuestion() {
        when(correctAnswer.isCorrect()).thenReturn(true);
        when(incorrectAnswer.isCorrect()).thenReturn(false);
        List<Answer> answers = Arrays.asList(incorrectAnswer, incorrectAnswer, correctAnswer);
        when(question.shuffleAnswers()).thenReturn(answers);
        assertEquals(3, questionService.askQuestion(question));
    }

    @Test
    @DisplayName("Method evaluateAnswer() correctly evaluates the answer")
    void  testEvaluateAnswer()
    {
        when(consoleService.readMessage()).thenReturn("5");
        assertTrue(questionService.evaluateAnswer(5));
    }

}