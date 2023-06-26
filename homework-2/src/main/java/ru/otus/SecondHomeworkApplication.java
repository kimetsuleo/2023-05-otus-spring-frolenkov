package ru.otus;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.service.QuestionService;

@ComponentScan
public class SecondHomeworkApplication {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(SecondHomeworkApplication.class);

        QuestionService service = context.getBean(QuestionService.class);
        service.startTesting();

        context.close();
    }
}