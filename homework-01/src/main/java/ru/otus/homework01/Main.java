package ru.otus.homework01;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.homework01.domain.Question;
import ru.otus.homework01.domain.Student;
import ru.otus.homework01.service.QuestionService;
import ru.otus.homework01.service.StudentService;

import java.rmi.StubNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        StudentService studentService = context.getBean(StudentService.class);
        QuestionService questionService = context.getBean(QuestionService.class);

        Student x = studentService.getStudentInfo();

        System.out.println(x);

        List<Question> questions = questionService.getQuestions();
        System.out.println(questions.toString());

        questionService.askQuestions(questions);

    }

}
