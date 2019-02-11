package ru.otus.homework04.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.otus.homework04.LocalizationConfig;
import ru.otus.homework04.LocalizationProps;
import ru.otus.homework04.domain.Question;
import ru.otus.homework04.util.CSVParser;

import java.io.IOException;
import java.util.List;

@Service
public class QuestionDaoImpl implements QuestionDao {

    private static final Logger log = LoggerFactory.getLogger(QuestionDaoImpl.class);

    private LocalizationProps config;

    public QuestionDaoImpl(LocalizationProps config) {
        this.config = config;
    }

    public List<Question> getQuestions()  {
        CSVParser parser = new CSVParser(config.getLocalizedQuestionFileName(), config.getDefaultQuestionFileName());
        List<Question> result = null;
        try {
            result = parser.parseFile();
        } catch (IOException e) {
            log.error("Exception occurred while parsing the file");
        }
        return result;
    }

}