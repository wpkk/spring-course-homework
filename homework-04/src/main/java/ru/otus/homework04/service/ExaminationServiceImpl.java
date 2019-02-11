package ru.otus.homework04.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExaminationServiceImpl implements ExaminationService {

    private final StudentService studentService;

    private final QuestionService questionService;

    @Autowired
    public ExaminationServiceImpl(StudentService studentService, QuestionService questionService, EvaluationService evaluationService) {
        this.studentService = studentService;
        this.questionService = questionService;
    }

    @Override
    public void startExamination() {
        studentService.getStudentInfo();
        questionService.askQuestions();
    }
}
