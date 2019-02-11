package ru.otus.homework04.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.otus.homework04.domain.Answer;
import ru.otus.homework04.domain.Question;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
public class CSVParser {

    private static final Logger log = LoggerFactory.getLogger(CSVParser.class);

    private Path questionFilePath;

    public CSVParser(String questionFileName, String defaultQuestionFileName) {
        try {
            URL defaultQuestionFileURL = getClass().getClassLoader().getResource(defaultQuestionFileName);
            URL questionFileURL = Optional.ofNullable(getClass().getClassLoader().getResource(questionFileName))
                    .orElse(defaultQuestionFileURL);
            questionFilePath = Paths.get(questionFileURL.toURI());
        } catch (URISyntaxException e) {
            log.error("The {} file could not be found", questionFileName);
        }
    }

    public List<Question> parseFile() throws IOException {
        String separator = ",";
        List<Question> questions = new ArrayList<>();
        List<String> tokens;
        Question currentQuestion;
        List<String> lines = Files.readAllLines(questionFilePath);
        List<Answer> answers;
        for (String line : lines) {
            answers = new ArrayList<>();

            tokens = new ArrayList<>(Arrays.asList(line.split(separator)));
            currentQuestion = new Question(tokens.remove(0));
            for (String token : tokens) {
                answers.add(new Answer(token));
            }
            answers.get(0).setCorrect(true);
            currentQuestion.setAnswers(answers);
            questions.add(currentQuestion);
        }

        return questions;
    }

}
