package ru.otus.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import ru.otus.dao.QuestionDao;
import ru.otus.dao.UserDao;
import ru.otus.domain.Answer;
import ru.otus.domain.Question;
import ru.otus.domain.User;

import java.util.List;

/**
 * @author kimetsu - 18.06.2023 - 13:41
 */
@DisplayName("class which test QuestionService")
public class QuestionServiceTest {
    @Mock
    private QuestionDao questionDao;

    @Mock
    private UserDao userDao;

    @Mock
    private IOService ioService;

    @BeforeEach
    public void setUp() {

        List<List<Answer>> optionAnswers = List.of(
                List.of(new Answer("Option 1"), new Answer("Option 2"), new Answer("Option 3")),
                List.of(new Answer("Option 4"), new Answer("Option 5"), new Answer("Option 6")),
                List.of(new Answer("Option 7"), new Answer("Option 8"), new Answer("Option 9"))
        );

        List<Question> questions = List.of(
                new Question("Question 1", "Option 1", optionAnswers.get(0)),
                new Question("Question 2", "Option 2", optionAnswers.get(1)),
                new Question("Question 3", "Option 3", optionAnswers.get(2))
        );
        Mockito.when(questionDao.getAllQuestions()).thenReturn(questions);
        Mockito.when(userDao.registerUser()).thenReturn(new User());
    }

    // test doesnt work because i dont now how to write this
    // in next homework i`m try to write success test

    @Test
    public void testStartTesting() {
        QuestionService questionService = new QuestionServiceImpl(questionDao, userDao, ioService);


        Mockito.when(ioService.readLine()).thenReturn("Option 1", "Option 6", "Option 7");
        Mockito.doNothing().when(ioService).println(Mockito.anyString());

        questionService.startTesting();

        Mockito.verify(ioService, Mockito.times(3)).println(Mockito.anyString());
        Mockito.verify(ioService, Mockito.times(3)).readLine();

        Mockito.verify(ioService, Mockito.times(1)).println(Mockito.contains("Score: 1/3"));
    }

}
