package ru.otus.homework05;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
public class AppProperties {

    @Getter
    private Locale userLocale = new Locale(System.getProperty("user.language"), System.getProperty("user.country"));

    public void setUserLocale(Locale userLocale) {
        this.userLocale = userLocale;
        System.setProperty("user.language", userLocale.getLanguage());
        System.setProperty("user.country", userLocale.getCountry());
    }
}
