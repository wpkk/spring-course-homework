package ru.otus.homework02.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.homework02.domain.Question;
import ru.otus.homework02.util.CSVParser;

import java.io.IOException;
import java.util.List;
@Service
public class QuestionDaoImpl implements QuestionDao {

    private final String questionFile;

    @Autowired
    public QuestionDaoImpl(String questionFile) {
        this.questionFile = questionFile;
    }

    public List<Question> getQuestions()  {
        CSVParser parser = new CSVParser(questionFile);
        List<Question> result = null;
        try {
            result = parser.parseFile();
        } catch (IOException e) {
            System.out.println("Exception occurred while parsing the file");
        }
        return result;
    }

}