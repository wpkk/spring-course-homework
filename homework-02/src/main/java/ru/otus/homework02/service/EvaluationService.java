package ru.otus.homework02.service;

import ru.otus.homework02.domain.Question;
import ru.otus.homework02.domain.Student;

import java.util.List;

public interface EvaluationService {

    void evaluateStudent(Student student, List<Question> questions);

}
