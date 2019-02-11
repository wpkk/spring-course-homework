package ru.otus.homework04.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@DisplayName("Class ExaminationServiceImpl")
class ExaminationServiceImplTest {

    @MockBean
    QuestionService questionService;

    @MockBean
    StudentService studentService;

    @Autowired
    ExaminationService examinationService;

    @Test
    @DisplayName("Correctly starts Spring context, executes each method 1 time")
    void testStartContextAndExamination() {

        examinationService.startExamination();
        verify(studentService, times(1)).getStudentInfo();
        verify(questionService, times(1)).askQuestions();
    }
}