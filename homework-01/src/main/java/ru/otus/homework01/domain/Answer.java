package ru.otus.homework01.domain;

public class Answer {

    private String answer;
    private boolean isCorrect;

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public Answer(String answer) {

        this.answer = answer;
        this.isCorrect = false;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answer='" + answer + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
