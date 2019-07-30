package ru.otus.homework04.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collections;
import java.util.List;

@ToString
public class Question {

    @Getter
    private final String question;
    @Getter @Setter
    private boolean isAnsweredCorrectly;
    @Getter @Setter
    private List<Answer> answers;

    public Question(String question) {
        this.question = question;
        this.isAnsweredCorrectly = false;
    }

    public List<Answer> shuffleAnswers() {
        Collections.shuffle(answers);
        return getAnswers();
    }

}