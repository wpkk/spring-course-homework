package ru.otus.homework04.shell;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.shell.Shell;
import org.springframework.test.annotation.DirtiesContext;
import ru.otus.homework04.AppProperties;
import ru.otus.homework04.service.*;

import java.util.Locale;

import static org.mockito.Mockito.*;

@SpringBootTest
@DisplayName("Class ShellCommands")
class ShellCommandsTest {

    @Autowired
    Shell shell;

    @MockBean
    AppProperties props;

    @MockBean
    ExaminationService examinationService;

    @MockBean
    EvaluationService evaluationService;

    private void setLocale(String languageCode, String countryCode) {
        shell.evaluate(() -> String.format("set-locale --language-code %s --country-code %s", languageCode, countryCode));
    }

    @Test
    @DisplayName("Sets the user locale via shell command")
    void testSetLocale() {

        String languageCode = "en";
        String countryCode = "US";

        setLocale(languageCode, countryCode);
        verify(props).setUserLocale(new Locale(languageCode, countryCode));
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    @DisplayName("Starts the examination via shell command")
    void testStartExamination() {
        shell.evaluate(() -> "start-examination");
        verify(examinationService).startExamination();
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    @DisplayName("Evaluates the student")
    void testEvaluateStudent() {
        shell.evaluate(() -> "start-examination");
        shell.evaluate(() -> "evaluate-student");
        verify(evaluationService).evaluateLastStudent();
    }

    @Test
    @DisplayName("Doesn't evaluate the student because the examination hasn't been started yet")
    void testEvaluateStudentNotStarted() {
        shell.evaluate(() -> "evaluate-student");
        verifyZeroInteractions(evaluationService);
    }


}