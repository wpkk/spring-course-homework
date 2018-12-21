package ru.otus.homework02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import ru.otus.homework02.domain.Question;
import ru.otus.homework02.domain.Student;
import ru.otus.homework02.service.EvaluationService;
import ru.otus.homework02.service.QuestionService;
import ru.otus.homework02.service.StudentService;

import java.util.List;

@ComponentScan(basePackages = "ru.otus.homework02")
@PropertySource("classpath:application.properties")
class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        StudentService studentService = context.getBean(StudentService.class);
        QuestionService questionService = context.getBean(QuestionService.class);
        EvaluationService evaluationService = context.getBean(EvaluationService.class);

        Student student = studentService.getStudentInfo();
        List<Question> questions = questionService.getQuestions();
        evaluationService.evaluateStudent(student, questionService.askQuestions(questions));

    }

}
