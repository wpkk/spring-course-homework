package ru.otus.homework03.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.homework03.AppProperties;
import ru.otus.homework03.LocalizationConfig;
import ru.otus.homework03.domain.Question;
import ru.otus.homework03.util.CSVParser;

import java.io.IOException;
import java.util.List;
@Service
public class QuestionDaoImpl implements QuestionDao {

    private String defaultQuestionFileName;

    private LocalizationConfig config;

    public QuestionDaoImpl(AppProperties properties, LocalizationConfig config) {
        this.config = config;
        this.defaultQuestionFileName = properties.getBase();
    }

    public List<Question> getQuestions()  {
        CSVParser parser = new CSVParser(config.getLocalizedQuestionFile(), defaultQuestionFileName);
        List<Question> result = null;
        try {
            result = parser.parseFile();
        } catch (IOException e) {
            System.out.println("Exception occurred while parsing the file");
        }
        return result;
    }

}