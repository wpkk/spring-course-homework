package ru.otus.homework04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.otus.homework04.service.ConsoleService;
import ru.otus.homework04.service.ConsoleServiceImpl;

@Configuration
public class LocalizationConfig {

    private AppProperties props;

    @Autowired
    public LocalizationConfig(AppProperties props) {
        this.props = props;
    }

    private MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("classpath:/i18n/bundle");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

    @Bean
    public ConsoleService consoleService() {
        return new ConsoleServiceImpl(messageSource(), props.getUserLocale());
    }
}
