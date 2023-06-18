package ru.otus.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.dao.QuestionDao;
import ru.otus.domain.Question;
import ru.otus.domain.User;

import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao questionDao;

    private final UserService userService;


    @Override
    public void getAllQuestions() {
        this.questionDao.getAllQuestions()
                .forEach(question -> System.out.println(question.getTitle() + " -> " + question.getAnswer()));
    }

    @Override
    public void askQuestion() {
        long count = 0;

        List<String> questions = this.questionDao.getAllQuestions().stream().map(Question::getTitle).toList();
        List<String> answers = this.questionDao.getAllQuestions().stream().map(Question::getAnswer).toList();


        User user = this.userService.registerUser();


        for (String question : questions) {
            String s = this.giveAnAnswer(question);
            for (String answer : answers) {
                if (answer.equalsIgnoreCase(s)) {
                    count++;
                }
            }
        }

        System.out.println(this.result(user, Math.toIntExact(count)));
    }

    private String result(User user, int mark) {
        return user.getFirstName() + " " + user.getLastName() + " mark: " + mark;
    }


    private String giveAnAnswer(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(question + " ");
        return scanner.nextLine();
    }
}
