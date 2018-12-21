package ru.otus.homework02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

@Configuration
public class LocalizationConfig {
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("classpath:/i18n/bundle");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

    @Bean
    public String questionFile(@Value("${file.name.en}") String fileNameEN,
                               @Value("${file.name.ru}") String fileNameRU) {
        return "ru".equals(System.getProperty("user.language")) ?
                fileNameRU :
                fileNameEN;
    }

    @Bean
    public Locale userLocale() {
        return "ru".equals(System.getProperty("user.language")) ?
            new Locale("ru", "RU") :
            Locale.ENGLISH;
    }

}
