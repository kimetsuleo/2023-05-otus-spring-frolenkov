package ru.otus;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class SecondHomeworkApplication {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(SecondHomeworkApplication.class);

        context.close();
    }
}