package ru.otus.service;

import ru.otus.dao.QuestionDao;

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
