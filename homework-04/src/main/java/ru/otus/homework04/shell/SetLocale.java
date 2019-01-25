package ru.otus.homework04.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.homework04.LocalizationConfig;

import java.util.Locale;

@ShellComponent
public class SetLocale {

    private LocalizationConfig localizationConfig;

    @Autowired
    public SetLocale(LocalizationConfig localizationConfig) {
        this.localizationConfig = localizationConfig;
    }

    @ShellMethod("Sets the user locale")
    public void setLocale(String languageCode, String countryCode) {
        localizationConfig.setUserLocale(new Locale(languageCode, countryCode));
    }

}
