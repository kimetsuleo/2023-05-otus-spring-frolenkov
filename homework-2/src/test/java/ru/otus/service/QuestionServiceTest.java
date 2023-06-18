package ru.otus.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.otus.dao.QuestionDao;
import ru.otus.domain.Question;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author kimetsu - 18.06.2023 - 13:41
 */
@DisplayName("class which test QuestionService")
public class QuestionServiceTest {

    @Test
    public void testAskQuestion() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Q1", "A1"));
        questions.add(new Question("Q2", "A2"));

        QuestionDao questionDao = Mockito.mock(QuestionDao.class);
        Mockito.when(questionDao.getAllQuestions()).thenReturn(questions);

        UserService userService = new UserServiceImpl();
        QuestionService questionService = new QuestionServiceImpl(questionDao, userService);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
        questionService.getAllQuestions();
        String output = baos.toString();

        String expectedOutput = "Q1 -> A1\nQ2 -> A2\n";
        assertEquals(expectedOutput, output);
    }

}
