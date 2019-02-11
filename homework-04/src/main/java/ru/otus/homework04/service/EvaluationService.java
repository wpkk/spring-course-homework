package ru.otus.homework04.service;

import ru.otus.homework04.domain.Question;
import ru.otus.homework04.domain.Student;

import java.util.List;

public interface EvaluationService {

    void evaluateStudent(Student student, List<Question> questions);

}
