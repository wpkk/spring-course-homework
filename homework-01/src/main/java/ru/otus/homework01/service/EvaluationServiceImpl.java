package ru.otus.homework01.service;

import ru.otus.homework01.domain.Question;
import ru.otus.homework01.domain.Student;

import java.util.List;

public class EvaluationServiceImpl implements EvaluationService {

    private final ConsoleService consoleService;

    public EvaluationServiceImpl(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    @Override
    public void evaluateStudent(Student student, List<Question> questions) {
        int totalQuestions = questions.size();
        long numberOfCorrectlyAnswered = questions.stream().filter(Question::isAnsweredCorrectly).count();
        consoleService.writeMessage(student.getName() + " " + student.getSurname()
                                    + ", you have correctly answered " + numberOfCorrectlyAnswered
                                    + " questions out of " + totalQuestions);
    }
}
