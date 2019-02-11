package ru.otus.homework04.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.homework04.domain.Question;
import ru.otus.homework04.domain.Student;

import java.util.List;

@Service
public class ExaminationServiceImpl implements ExaminationService {

    private final StudentService studentService;

    private final QuestionService questionService;

    private final EvaluationService evaluationService;

    @Autowired
    public ExaminationServiceImpl(StudentService studentService, QuestionService questionService, EvaluationService evaluationService) {
        this.studentService = studentService;
        this.questionService = questionService;
        this.evaluationService = evaluationService;
    }

    @Override
    public void startExamination() {
        Student student = studentService.getStudentInfo();
        List<Question> questions = questionService.getQuestions();
        evaluationService.evaluateStudent(student, questionService.askQuestions(questions));
    }
}
