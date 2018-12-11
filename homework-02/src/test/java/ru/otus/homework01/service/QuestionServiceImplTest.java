package ru.otus.homework01.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.homework01.dao.QuestionDao;
import ru.otus.homework01.domain.Answer;
import ru.otus.homework01.domain.Question;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Java6Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Class QuestionServiceImpl")
class QuestionServiceImplTest {
    @Mock
    private ConsoleService consoleService;
    @Mock
    private QuestionDao questionDao;
    @Mock
    private Answer correctAnswer;
    @Mock
    private Answer incorrectAnswer;
    @Mock
    private Question question;

    @Test
    @DisplayName("Method getQuestions() calls dao only once")
    void testGetQuestions() {
        QuestionService questionService = new QuestionServiceImpl(questionDao, consoleService);
        questionService.getQuestions();
        verify(questionDao, times(1)).getQuestions();
    }

    @Test
    @DisplayName("Method askQuestions correctly sets fields of questions")
    void testAskQuestions() {
        QuestionService questionService = new QuestionServiceImpl(questionDao, consoleService) {

            @Override
            public boolean evaluateAnswer(int correctAnswerNumber) {
                return true;
            }
        };

        doCallRealMethod().when(question).setAnsweredCorrectly(anyBoolean());

        List<Question> questions = Arrays.asList(question, question);

        questionService.askQuestions(questions);
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
        QuestionService questionService = new QuestionServiceImpl(questionDao, consoleService);
        assertEquals(3, questionService.askQuestion(question));
    }

    @Test
    @DisplayName("Method evaluateAnswer() correctly evaluates the answer")
    void  testEvaluateAnswer()
    {
        when(consoleService.readMessage()).thenReturn("5");
        QuestionServiceImpl questionService = new QuestionServiceImpl(questionDao, consoleService);
        assertTrue(questionService.evaluateAnswer(5));
    }

}