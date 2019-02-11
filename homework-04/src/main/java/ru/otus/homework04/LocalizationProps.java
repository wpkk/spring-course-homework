package ru.otus.homework04;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Locale;

@ConfigurationProperties
public class LocalizationProps {

    private AppProperties properties;
    private Locale userLocale;

    public LocalizationProps(AppProperties properties) {
        this.properties = properties;
        this.userLocale = new Locale(System.getProperty("user.language"), System.getProperty("user.country"));
    }

    public String getLocalizedQuestionFileName() {
        return String.format(properties.getTemplate(), "-" + userLocale.getLanguage());
    }

    public String getDefaultQuestionFileName() {
        return properties.getBase();
    }

    public Locale getUserLocale() {
        return userLocale;
    }

    public void setUserLocale(Locale userLocale) {
        this.userLocale = userLocale;
        System.setProperty("user.language", userLocale.getLanguage());
        System.setProperty("user.country", userLocale.getCountry());
    }
}