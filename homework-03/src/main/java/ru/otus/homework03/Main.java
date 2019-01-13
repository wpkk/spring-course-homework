package ru.otus.homework03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import ru.otus.homework03.domain.Question;
import ru.otus.homework03.domain.Student;
import ru.otus.homework03.service.EvaluationService;
import ru.otus.homework03.service.QuestionService;
import ru.otus.homework03.service.StudentService;

import java.util.List;
//todo rename this class
//@PropertySource("classpath:application.yml")
@SpringBootApplication()
public class Main {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Main.class, args);
        StudentService studentService = context.getBean(StudentService.class);
        QuestionService questionService = context.getBean(QuestionService.class);
        EvaluationService evaluationService = context.getBean(EvaluationService.class);

        Student student = studentService.getStudentInfo();
        List<Question> questions = questionService.getQuestions();
        evaluationService.evaluateStudent(student, questionService.askQuestions(questions));

    }

}
