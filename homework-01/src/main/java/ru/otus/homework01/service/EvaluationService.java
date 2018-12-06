package ru.otus.homework01.service;

import ru.otus.homework01.domain.Question;
import ru.otus.homework01.domain.Student;

import java.util.List;

public interface EvaluationService {

    void evaluateStudent(Student student, List<Question> questions);

}
