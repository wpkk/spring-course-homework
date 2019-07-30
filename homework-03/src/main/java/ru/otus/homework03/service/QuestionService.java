package ru.otus.homework03.service;

import ru.otus.homework03.domain.Question;

import java.util.List;

public interface QuestionService {

    List<Question> getQuestions();

    List<Question> askQuestions(List<Question> questions);

    int askQuestion(Question question);

    boolean evaluateAnswer(int answerNumber);
}
