package ru.otus.homework01.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.homework01.domain.Student;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Class StudentServiceImpl")
public class StudentServiceImplTest {
    @Mock
    private ConsoleService consoleService;

    @Test
    @DisplayName("Returns correct student object")
    public void testExpectedInput() {
        when(consoleService.readMessage()).thenReturn("name").thenReturn("surname");

        StudentService studentService = new StudentServiceImpl(consoleService);
        assertEquals(new Student("name", "surname"), studentService.getStudentInfo());
    }

    @Test
    @DisplayName("Rejects empty name")
    public void testEmptyName() {
        when(consoleService.readMessage()).thenReturn("").thenReturn("name").thenReturn("surname");

        StudentService studentService = new StudentServiceImpl(consoleService);
        assertNotEquals(new Student("", "surname"), studentService.getStudentInfo());
    }

    @Test
    @DisplayName("Rejects empty surname")
    public void testEmptySurname() {
        when(consoleService.readMessage()).thenReturn("name").thenReturn("").thenReturn("surname");

        StudentService studentService = new StudentServiceImpl(consoleService);
        assertNotEquals(new Student("name", ""), studentService.getStudentInfo());
    }

}