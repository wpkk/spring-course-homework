package ru.otus.homework02.domain;

public class Answer {

    private final String answer;
    private boolean isCorrect;

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public String getAnswer() {
        return answer;
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
