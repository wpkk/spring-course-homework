package ru.otus.homework01;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.homework01.domain.Question;
import ru.otus.homework01.domain.Student;
import ru.otus.homework01.service.EvaluationService;
import ru.otus.homework01.service.QuestionService;
import ru.otus.homework01.service.StudentService;

import java.util.List;

class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        StudentService studentService = context.getBean(StudentService.class);
        QuestionService questionService = context.getBean(QuestionService.class);
        EvaluationService evaluationService = context.getBean(EvaluationService.class);

        Student student = studentService.getStudentInfo();
        List<Question> questions = questionService.getQuestions();
        evaluationService.evaluateStudent(student, questionService.askQuestions(questions));

    }

}
