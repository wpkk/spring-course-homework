package ru.otus.homework03.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.homework03.domain.Question;
import ru.otus.homework03.domain.Student;

import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
@DisplayName("Class EvaluationServiceImpl")
class EvaluationServiceImplTest {
    @Mock
    private ConsoleService consoleService;
    @Mock
    private List<Question> questions;

    @Test
    @DisplayName("Prints correct information to console")
    void test() {
        when(questions.size()).thenReturn(50);

        Student student = mock(Student.class);
        when(student.getName()).thenReturn("name");
        when(student.getSurname()).thenReturn("surname");
        EvaluationService evaluationService = new EvaluationServiceImpl(consoleService);
        evaluationService.evaluateStudent(student, questions);
        Mockito.verify(consoleService).writeLocalizedMessage("message.evaluateStudent",
                "name", "surname", 0L, 50);

    }

}