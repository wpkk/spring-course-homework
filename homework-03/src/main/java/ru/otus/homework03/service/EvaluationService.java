package ru.otus.homework03.service;

import ru.otus.homework03.domain.Question;
import ru.otus.homework03.domain.Student;

import java.util.List;

public interface EvaluationService {

    void evaluateStudent(Student student, List<Question> questions);

}
