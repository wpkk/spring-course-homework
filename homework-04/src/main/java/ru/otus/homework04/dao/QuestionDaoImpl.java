package ru.otus.homework04.dao;

import org.springframework.stereotype.Service;
import ru.otus.homework04.LocalizationConfig;
import ru.otus.homework04.domain.Question;
import ru.otus.homework04.util.CSVParser;

import java.io.IOException;
import java.util.List;
@Service
public class QuestionDaoImpl implements QuestionDao {

    private LocalizationConfig config;

    public QuestionDaoImpl(LocalizationConfig config) {
        this.config = config;
    }

    public List<Question> getQuestions()  {
        CSVParser parser = new CSVParser(config.getLocalizedQuestionFileName(), config.getDefaultQuestionFileName());
        List<Question> result = null;
        try {
            result = parser.parseFile();
        } catch (IOException e) {
            System.out.println("Exception occurred while parsing the file");
        }
        return result;
    }

}