package ru.otus.homework01.service;

import org.junit.Test;
import org.mockito.Mockito;
import ru.otus.homework01.domain.Question;
import ru.otus.homework01.domain.Student;

import java.util.List;

import static org.mockito.Mockito.*;


public class EvaluationServiceImplTest {

    private ConsoleService consoleService = mock(ConsoleServiceImpl.class);

    @Test
    public void test() {
        List<Question> questions = mock(List.class);
        when(questions.size()).thenReturn(50);

        Student student = mock(Student.class);
        when(student.getName()).thenReturn("name");
        when(student.getSurname()).thenReturn("surname");
        //TODO Understand how to mock the stream call
        EvaluationService evaluationService = new EvaluationServiceImpl(consoleService);
        evaluationService.evaluateStudent(student, questions);
        Mockito.verify(consoleService).writeMessage("asdf");

    }


}