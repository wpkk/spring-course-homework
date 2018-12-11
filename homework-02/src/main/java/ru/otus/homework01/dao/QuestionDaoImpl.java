package ru.otus.homework01.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.homework01.domain.Question;
import ru.otus.homework01.util.CSVParser;

import java.io.IOException;
import java.util.List;
@Service
public class QuestionDaoImpl implements QuestionDao {

    private final String fileName;

    public QuestionDaoImpl(@Value("${file.name}") String fileName) {
        this.fileName = fileName;
    }

    public List<Question> getQuestions()  {
        CSVParser parser = new CSVParser(fileName);
        List<Question> result = null;
        try {
            result = parser.parseFile();
        } catch (IOException e) {
            System.out.println("Exception occurred while parsing the file");
        }
        return result;
    }

}