package ru.otus.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.dao.QuestionDao;
import ru.otus.dao.UserDao;
import ru.otus.domain.Answer;
import ru.otus.domain.Question;
import ru.otus.domain.User;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao questionDao;

    private final UserDao userDao;

    private final IOService ioService;

    @Override
    public void startTesting() {
        int count = 0;

        List<String> questions = this.questionDao.getAllQuestions().stream().map(Question::getTitle).toList();

        List<List<Answer>> listAnswers = List.of(
                List.of(
                        new Answer("100"),
                        new Answer("116"),
                        new Answer("125")
                ),
                List.of(
                        new Answer("6"),
                        new Answer("5"),
                        new Answer("2")
                ),
                List.of(
                        new Answer("Russia"),
                        new Answer("USA"),
                        new Answer("China")
                ),
                List.of(
                        new Answer("Great Britain"),
                        new Answer("Mexico"),
                        new Answer("Japan")
                ),
                List.of(
                        new Answer("maybe"),
                        new Answer("no"),
                        new Answer("yes")
                ));


        for (List<Answer> listAnswer : listAnswers) {
            for (String question : questions) {
                this.ioService.println(question);
                this.ioService.println(listAnswer.toString());
                String s = this.giveAnAnswer();
                if (s.equalsIgnoreCase(listAnswer.stream().map(Answer::getText).toString())) {
                    count++;
                }
            }
        }

        User user = this.userDao.registerUser();


        this.ioService.println("");
        this.ioService.println(this.result(user, Math.toIntExact(count)));
    }

    private String result(User user, int mark) {
        return user.getFirstName() + " " + user.getLastName() + " mark: " + mark;
    }


    private String giveAnAnswer() {
        this.ioService.println("Write a correct answer: ");
        return this.ioService.readLine();
    }
}