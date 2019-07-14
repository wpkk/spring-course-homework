package ru.otus.homework04.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.otus.homework04.domain.Question;
import ru.otus.homework04.domain.Student;

import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
@DisplayName("Class EvaluationServiceImpl")
class EvaluationServiceImplTest {
    @MockBean
    private ConsoleService consoleService;
    @Autowired
    EvaluationService evaluationService;
    @Mock
    private List<Question> questions;

    @Test
    @DisplayName("Prints correct information to console")
    void test() {
        when(questions.size()).thenReturn(50);

        Student student = mock(Student.class);
        when(student.getName()).thenReturn("name");
        when(student.getSurname()).thenReturn("surname");
        evaluationService.evaluateStudent(student, questions);
        Mockito.verify(consoleService).writeLocalizedMessage("message.evaluateStudent",
                "name", "surname", 0L, 50);

    }

}