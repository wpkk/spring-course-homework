package ru.otus.homework04;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Locale;

@ConfigurationProperties(prefix = "file.name")
public class AppProperties {

    private String base;

    private String template;

    private Locale userLocale = new Locale(System.getProperty("user.language"), System.getProperty("user.country"));

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getLocalizedQuestionFileName() {
        return String.format(getTemplate(), "-" + userLocale.getLanguage());
    }

    public String getDefaultQuestionFileName() {
        return getBase();
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
