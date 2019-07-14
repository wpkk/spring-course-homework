package ru.otus.homework04.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Answer {

    @Getter
    private final String answer;
    @Getter @Setter
    private boolean isCorrect;

    public Answer(String answer) {

        this.answer = answer;
        this.isCorrect = false;
    }

}