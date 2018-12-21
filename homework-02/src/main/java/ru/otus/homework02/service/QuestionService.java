package ru.otus.homework02.service;

import ru.otus.homework02.domain.Question;

import java.util.List;

public interface QuestionService {

    List<Question> getQuestions();

    List<Question> askQuestions(List<Question> questions);

    int askQuestion(Question question);

    boolean evaluateAnswer(int answerNumber);
}
