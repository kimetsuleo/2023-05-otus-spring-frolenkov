package ru.otus;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class SecondHomeworkApplication {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext();

        context.close();
    }
}