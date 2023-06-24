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

        List<Question> questions = this.questionDao.getAllQuestions();

        User user = this.userDao.registerUser();

        for (Question question : questions) {
            this.ioService.print(question.getTitle() + " ");
            List<Answer> listAnswer = question.getOptionAnswers();
            this.ioService.println(listAnswer.toString());
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