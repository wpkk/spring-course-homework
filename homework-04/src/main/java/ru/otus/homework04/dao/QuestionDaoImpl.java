package ru.otus.homework04.dao;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.otus.homework04.AppProperties;
import ru.otus.homework04.domain.Question;
import ru.otus.homework04.util.CSVParser;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
public class QuestionDaoImpl implements QuestionDao {

    private AppProperties props;

    @Getter @Setter
    private List<Question> answeredQuestions;

    public QuestionDaoImpl(AppProperties props) {
        this.props = props;
    }

    public List<Question> getQuestions()  {
        CSVParser parser = new CSVParser(props.getLocalizedQuestionFileName(), props.getDefaultQuestionFileName());
        List<Question> result = null;
        try {
            result = parser.parseFile();
        } catch (IOException e) {
            log.error("Exception occurred while parsing the file");
        }
        return result;
    }

}