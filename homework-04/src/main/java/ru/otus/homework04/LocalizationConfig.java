package ru.otus.homework04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.otus.homework04.service.ConsoleServiceImpl;

import java.util.Locale;

@Configuration
public class LocalizationConfig {

    @Autowired
    private LocalizationProps localizationProps;

    private MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("classpath:/i18n/bundle");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

    @Bean
    public ConsoleServiceImpl consoleService() {
        return new ConsoleServiceImpl(messageSource(), localizationProps.getUserLocale());
    }
}
