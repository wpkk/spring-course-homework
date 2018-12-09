package ru.otus.homework01.service;

import ru.otus.homework01.domain.Question;

import java.util.List;

public interface QuestionService {

    List<Question> getQuestions();

    List<Question> askQuestions(List<Question> questions);

    int askQuestion(Question question);

    boolean evaluateAnswer(int answerNumber);
}
