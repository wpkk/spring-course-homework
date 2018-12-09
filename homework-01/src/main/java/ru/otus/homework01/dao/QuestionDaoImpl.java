package ru.otus.homework01.dao;

import ru.otus.homework01.domain.Question;
import ru.otus.homework01.util.CSVParser;

import java.io.IOException;
import java.util.List;

public class QuestionDaoImpl implements QuestionDao {
    public List<Question> getQuestions()  {
        CSVParser parser = new CSVParser();
        List<Question> result = null;
        try {
            result = parser.parseFile();
        } catch (IOException e) {
            System.out.println("Exception occurred while parsing the file");
        }
        return result;
    }
}