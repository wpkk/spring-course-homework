package ru.otus.homework04.util;

import lombok.extern.slf4j.Slf4j;
import ru.otus.homework04.domain.Answer;
import ru.otus.homework04.domain.Question;

import java.io.FileNotFoundException;
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

@Slf4j
public class CSVParser {

    private Path questionFilePath;

    public CSVParser(String questionFileName, String defaultQuestionFileName) {
        try {
            URL defaultQuestionFileURL = Optional.ofNullable(getClass().getClassLoader().getResource(defaultQuestionFileName))
                    .orElseThrow(() -> new FileNotFoundException("Default question file was not found"));
            URL questionFileURL = Optional.ofNullable(getClass().getClassLoader().getResource(questionFileName))
                    .orElse(defaultQuestionFileURL);
            questionFilePath = Paths.get(questionFileURL.toURI());
        } catch (URISyntaxException| FileNotFoundException e) {
            log.error("The {} file could not be found", questionFileName);
            throw new RuntimeException(e);
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
