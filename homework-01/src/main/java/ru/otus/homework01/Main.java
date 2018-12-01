package ru.otus.homework01;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.homework01.domain.Question;
import ru.otus.homework01.service.QuestionDataService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        QuestionDataService questionDataService = context.getBean(QuestionDataService.class);
        List<Question> questions = questionDataService.getQuestions();
        System.out.println(questions.toString());
    }

}
