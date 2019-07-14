package ru.otus.homework04;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Locale;

@ConfigurationProperties(prefix = "file.name")
public class AppProperties {

    @Getter @Setter
    private String base;
    @Getter @Setter
    private String template;
    @Getter
    private Locale userLocale = new Locale(System.getProperty("user.language"), System.getProperty("user.country"));

    public String getLocalizedQuestionFileName() {
        return String.format(getTemplate(), "-" + userLocale.getLanguage());
    }

    public String getDefaultQuestionFileName() {
        return getBase();
    }

    public void setUserLocale(Locale userLocale) {
        this.userLocale = userLocale;
        System.setProperty("user.language", userLocale.getLanguage());
        System.setProperty("user.country", userLocale.getCountry());
    }

}
