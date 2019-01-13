package ru.otus.homework03;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.otus.homework03.service.ConsoleServiceImpl;

import java.util.Locale;

@Configuration
public class LocalizationConfig {

    private MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("classpath:/i18n/bundle");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

    public static String getLocalizedQuestionFile(String fileNameTemplate) {
        return String.format(fileNameTemplate, "-" + System.getProperty("user.language"));
    }

    private Locale userLocale() {
        return new Locale(System.getProperty("user.language"), System.getProperty("user.country"));
    }

    @Bean
    public ConsoleServiceImpl consoleService() {
        return new ConsoleServiceImpl(messageSource(), userLocale());
    }
}
