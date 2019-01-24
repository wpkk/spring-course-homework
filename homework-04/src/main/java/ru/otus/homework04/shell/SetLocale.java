package ru.otus.homework04.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.homework04.service.LocalizationService;

@ShellComponent
public class SetLocale {

    private LocalizationService localizationService;

    @Autowired
    public SetLocale(LocalizationService localizationService) {
        this.localizationService = localizationService;
    }

    @ShellMethod("Sets the user locale")
    public void setLocale(String locale) {
        localizationService.setLocale(locale);
    }

}
