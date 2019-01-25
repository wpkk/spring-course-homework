package ru.otus.homework04;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.otus.homework04.service.ConsoleServiceImpl;

import java.util.Locale;

@Configuration
public class LocalizationConfig {

    private AppProperties properties;
    private Locale userLocale;

    public LocalizationConfig(AppProperties properties) {
        this.properties = properties;
        this.userLocale = new Locale(System.getProperty("user.language"), System.getProperty("user.country"));
    }

    private MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("classpath:/i18n/bundle");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

    public String getLocalizedQuestionFileName() {
        return String.format(properties.getTemplate(), "-" + userLocale.getLanguage());
    }

    public String getDefaultQuestionFileName() {
        return properties.getBase();
    }

    public void setUserLocale(Locale userLocale) {
        this.userLocale = userLocale;
        System.setProperty("user.language", userLocale.getLanguage());
        System.setProperty("user.country", userLocale.getCountry());
    }

    @Bean
    public ConsoleServiceImpl consoleService() {
        return new ConsoleServiceImpl(messageSource(), userLocale);
    }
}
