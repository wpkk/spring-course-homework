package ru.otus.homework01.domain;

import java.util.List;

public class Question {

    private final String question;
    private boolean isAnsweredCorrectly;
    private List<Answer> answers;

    public Question(String question) {
        this.question = question;
        this.isAnsweredCorrectly = false;
    }

    public String getQuestion() {
        return question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public boolean isAnsweredCorrectly() {
        return isAnsweredCorrectly;
    }

    public void setAnsweredCorrectly(boolean answeredCorrectly) {
        isAnsweredCorrectly = answeredCorrectly;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", isAnsweredCorrectly=" + isAnsweredCorrectly +
                ", answers=" + answers +
                '}';
    }



}
