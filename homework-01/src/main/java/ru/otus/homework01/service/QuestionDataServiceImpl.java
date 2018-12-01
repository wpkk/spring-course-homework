package ru.otus.homework01.service;

import ru.otus.homework01.dao.QuestionDao;
import ru.otus.homework01.domain.Question;

import java.util.List;

public class QuestionDataServiceImpl implements QuestionDataService {

    private QuestionDao questionDao;

    public QuestionDataServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public List<Question> getQuestions() {
        return questionDao.getQuestions();
    }
}