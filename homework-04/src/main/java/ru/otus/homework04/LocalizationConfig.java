package ru.otus.homework04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.homework04.service.ConsoleService;
import ru.otus.homework04.service.ConsoleServiceImpl;

@Configuration
public class LocalizationConfig {

    private AppProperties props;

    @Autowired
    public LocalizationConfig(AppProperties props) {
        this.props = props;
    }

    @Bean @Autowired
    public ConsoleService consoleService(MessageSource messageSource) {
        return new ConsoleServiceImpl(messageSource, props);
    }

}
