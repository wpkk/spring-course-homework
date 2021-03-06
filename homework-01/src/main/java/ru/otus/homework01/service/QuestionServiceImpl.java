package ru.otus.homework01.service;

import ru.otus.homework01.dao.QuestionDao;
import ru.otus.homework01.domain.Answer;
import ru.otus.homework01.domain.Question;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao questionDao;
    private final ConsoleService consoleService;

    public QuestionServiceImpl(QuestionDao questionDao, ConsoleService consoleService) {
        this.questionDao = questionDao;
        this.consoleService = consoleService;
    }

    @Override
    public List<Question> getQuestions() {
        return questionDao.getQuestions();
    }

    @Override
    public List<Question> askQuestions(List<Question> questions) {
        consoleService.writeMessage("Please enter the number of the correct answer:");
        for (Question question: questions) {
            question.setAnsweredCorrectly(evaluateAnswer(askQuestion(question)));
        }
        return questions;
    }

    @Override
    public int askQuestion(Question question) {
        int correctAnswerNumber = 0;
        int answerCounter = 1;
        List<Answer> answers = question.shuffleAnswers();
        consoleService.writeMessage(question.getQuestion());
        for (Answer answer : answers) {
            consoleService.writeMessage(answerCounter + "." + answer.getAnswer());
            if (answer.isCorrect()) {
                correctAnswerNumber = answerCounter;
            }
            answerCounter++;
        }
        return correctAnswerNumber;
    }

    @Override
    public boolean evaluateAnswer(int correctAnswerNumber) {
        return consoleService.readMessage().equals(String.valueOf(correctAnswerNumber));
    }


}