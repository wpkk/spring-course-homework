package ru.otus.homework01.util;

import ru.otus.homework01.domain.Answer;
import ru.otus.homework01.domain.Question;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVParser {

    private Path questionsFile;

    public CSVParser() {
        try {
            questionsFile = Paths.get(getClass().getClassLoader().getResource("questions-answers.csv").toURI());
        } catch (URISyntaxException e) {
            System.out.println("The questions-answers.csv file could not be found");;
        }
    }

    public List<Question> parseFile() throws IOException {
        String separator = ",";
        List<Question> questions = new ArrayList<>();
        List<String> tokens;
        Question currentQuestion;
        List<String> lines = Files.readAllLines(questionsFile);
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
