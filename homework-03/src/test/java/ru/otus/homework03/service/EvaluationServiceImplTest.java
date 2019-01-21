package ru.otus.homework03.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.homework03.domain.Question;
import ru.otus.homework03.domain.Student;

import java.util.List;

import static org.mockito.Mockito.*;

//@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
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