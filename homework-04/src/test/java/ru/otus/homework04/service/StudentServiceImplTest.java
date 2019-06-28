package ru.otus.homework04.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.otus.homework04.domain.Student;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@DisplayName("Class StudentServiceImpl")
class StudentServiceImplTest {
    @MockBean
    private ConsoleService consoleService;
    @Autowired
    private StudentService studentService;

    @Test
    @DisplayName("Returns correct student object")
    void testExpectedInput() {
        when(consoleService.readMessage()).thenReturn("name").thenReturn("surname");

//        StudentService studentService = new StudentServiceImpl(consoleService);
        studentService.getStudentInfo();
        assertEquals(new Student("name", "surname"), studentService.getStudent());
    }

    @Test
    @DisplayName("Rejects empty name")
    void testEmptyName() {
        when(consoleService.readMessage()).thenReturn("").thenReturn("name").thenReturn("surname");

//        StudentService studentService = new StudentServiceImpl(consoleService);
        studentService.getStudentInfo();
        assertNotEquals(new Student("", "surname"), studentService.getStudent());
    }

    @Test
    @DisplayName("Rejects empty surname")
    void testEmptySurname() {
        when(consoleService.readMessage()).thenReturn("name").thenReturn("").thenReturn("surname");

//        StudentService studentService = new StudentServiceImpl(consoleService);
        studentService.getStudentInfo();
        assertNotEquals(new Student("name", ""), studentService.getStudent());
    }

}