package ru.otus.homework01.service;

import ru.otus.homework01.domain.Question;

import java.util.List;

public interface QuestionService {

    List<Question> getQuestions();

    void askQuestions(List<Question> questions);

}
