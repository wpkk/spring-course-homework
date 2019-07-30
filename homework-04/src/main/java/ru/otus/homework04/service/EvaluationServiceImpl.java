package ru.otus.homework04.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.homework04.domain.Question;
import ru.otus.homework04.domain.Student;

import java.util.List;

@Service
public class EvaluationServiceImpl implements EvaluationService {

    private final ConsoleService consoleService;
    private final StudentService studentService;
    private final QuestionService questionService;
    private static final String MESSAGE_EVALUATE_STUDENT = "message.evaluateStudent";

    @Autowired
    EvaluationServiceImpl(ConsoleService consoleService, StudentService studentService, QuestionService questionService) {
        this.consoleService = consoleService;
        this.studentService = studentService;
        this.questionService = questionService;
    }

    @Override
    public void evaluateStudent(Student student, List<Question> questions) {
        int totalQuestions = questions.size();
        long numberOfCorrectlyAnswered = questions.stream().filter(Question::isAnsweredCorrectly).count();

        consoleService.writeLocalizedMessage(MESSAGE_EVALUATE_STUDENT,
                student.getName(),
                student.getSurname(),
                numberOfCorrectlyAnswered,
                totalQuestions);
    }

    @Override
    public void evaluateLastStudent() {
        evaluateStudent(studentService.getStudent(), questionService.getAnsweredQuestions());
    }
}
