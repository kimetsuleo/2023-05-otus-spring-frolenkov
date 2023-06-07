package ru.otus;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.service.QuastionService;
import ru.otus.service.QuastionServiceImpl;

public class Application {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuastionService service = context.getBean(QuastionServiceImpl.class);
        service.getAllQuastions();
    }
}