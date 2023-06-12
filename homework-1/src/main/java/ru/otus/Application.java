package ru.otus;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.service.QuestionServiceImpl;
import ru.otus.service.QuestionService;

public class Application {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("/spring-context.xml");

        QuestionService service = context.getBean(QuestionServiceImpl.class);
        service.getAllQuestions();

        context.close();
    }
}