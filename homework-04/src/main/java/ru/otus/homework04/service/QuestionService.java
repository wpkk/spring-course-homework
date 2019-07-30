package ru.otus.homework04.service;

import ru.otus.homework04.domain.Question;

import java.util.List;

public interface QuestionService {

    void askQuestions();

    int askQuestion(Question question);

    boolean evaluateAnswer(int answerNumber);

    List<Question> getAnsweredQuestions();
}
