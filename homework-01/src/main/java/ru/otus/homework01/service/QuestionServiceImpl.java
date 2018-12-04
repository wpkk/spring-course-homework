package ru.otus.homework01.service;

import ru.otus.homework01.dao.QuestionDao;
import ru.otus.homework01.domain.Question;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {

    private QuestionDao questionDao;
    private ConsoleService consoleService;

    public QuestionServiceImpl(QuestionDao questionDao, ConsoleService consoleService) {
        this.questionDao = questionDao;
        this.consoleService = consoleService;
    }

    @Override
    public List<Question> getQuestions() {
        return questionDao.getQuestions();
    }

    @Override
    public void askQuestions(List<Question> questions) {

        consoleService.writeMessage("Please answer the following questions:\n");

        for (Question question: questions) {
            askQuestion(question);
        }
    }

    public void askQuestion(Question question) {


    }



}