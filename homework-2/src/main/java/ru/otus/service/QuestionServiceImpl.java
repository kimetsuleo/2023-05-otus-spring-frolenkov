package ru.otus.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.dao.QuestionDao;
import ru.otus.dao.UserDao;
import ru.otus.domain.Answer;
import ru.otus.domain.Question;
import ru.otus.domain.User;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao questionDao;

    private final UserDao userDao;

    private final IOService ioService;

    private List<List<Answer>> listAnswer = List.of(
            List.of(
                    new Answer("100"),
                    new Answer("116"),
                    new Answer("125")
            ),
            List.of(
                    new Answer("6"),
                    new Answer("4"),
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


    @Override
    public void startTesting() {
        int count = 0;

        List<Question> questions = this.questionDao.getAllQuestions();

        for (int i = 0; i < questions.size(); i++) {
            questions.get(i).setOptionAnswers(listAnswer.get(i));
        }

        User user = this.userDao.registerUser();

        for (Question question : questions) {
            this.ioService.print(question.getTitle() + " ");
            List<Answer> listAnswer = question.getOptionAnswers();
            this.ioService.println(listAnswer.stream().map(Answer::getText).collect(Collectors.joining(",")));
            String s = this.giveAnAnswer();
            if (question.getAnswer().equalsIgnoreCase(s)) {
                count++;
            }
        }

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