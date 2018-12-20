package ru.otus.homework01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.homework01.domain.Question;
import ru.otus.homework01.domain.Student;

import java.util.List;

@Service
public class EvaluationServiceImpl implements EvaluationService {

    private final ConsoleService consoleService;
    @Autowired
    EvaluationServiceImpl(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    @Override
    public void evaluateStudent(Student student, List<Question> questions) {
        int totalQuestions = questions.size();
        long numberOfCorrectlyAnswered = questions.stream().filter(Question::isAnsweredCorrectly).count();

        consoleService.writeLocalizedMessage("message.evaluateStudent", new Object[]{
                student.getName(),
                student.getSurname(),
                numberOfCorrectlyAnswered,
                totalQuestions});
    }
}
