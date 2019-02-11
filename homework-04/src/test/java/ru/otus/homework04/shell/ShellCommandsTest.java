package ru.otus.homework04.shell;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.shell.Shell;
import ru.otus.homework04.LocalizationConfig;
import ru.otus.homework04.LocalizationProps;
import ru.otus.homework04.service.*;

import java.util.Locale;

import static org.mockito.Mockito.*;

@SpringBootTest
@DisplayName("Class ShellCommands")
class ShellCommandsTest {

    @Autowired
    Shell shell;

    @MockBean
    ExaminationService examinationService;

    @MockBean
    LocalizationProps localizationProps;

    private void setLocale(String languageCode, String countryCode) {
        shell.evaluate(() -> String.format("set-locale --language-code %s --country-code %s", languageCode, countryCode));
    }

    @Test
    @DisplayName("Sets the user locale via shell command")
    void testSetLocale() {

        String languageCode = "en";
        String countryCode = "US";

        setLocale(languageCode, countryCode);
        verify(localizationProps).setUserLocale(new Locale(languageCode, countryCode));
    }

    @Test
    @DisplayName("Starts the examination via shell command")
    void testStartExamination() {
        shell.evaluate(() -> "start-examination");
        verify(examinationService).startExamination();
    }
}