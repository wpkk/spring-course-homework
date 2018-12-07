package ru.otus.homework01.service;

import org.junit.Test;
import org.mockito.Mock;
import ru.otus.homework01.domain.Student;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class StudentServiceImplTest {

    private ConsoleService consoleService = mock(ConsoleService.class);

    @Test
    public void testExpectedInput() {
        when(consoleService.readMessage()).thenReturn("name").thenReturn("surname");

        StudentService studentService = new StudentServiceImpl(consoleService);
        assertEquals(new Student("name", "surname"), studentService.getStudentInfo());
    }


}