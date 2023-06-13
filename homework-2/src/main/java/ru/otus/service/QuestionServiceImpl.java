package ru.otus.service;

import org.springframework.stereotype.Service;
import ru.otus.dao.QuestionDao;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao questionDao;

    public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public void getAllQuestions() {
        this.questionDao.getAllQuestions()
                .forEach(question -> System.out.println(question.getTitle() + " -> " + question.getAnswers()));
    }
}
