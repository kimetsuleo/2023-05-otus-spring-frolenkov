package ru.otus.service;

import ru.otus.dao.QuastionDao;

public class QuastionServiceImpl implements QuastionService {

    private final QuastionDao quastionDao;

    public QuastionServiceImpl(QuastionDao quastionDao) {
        this.quastionDao = quastionDao;
    }

    @Override
    public void getAllQuastions() {
        this.quastionDao.getAllQuastions()
                .forEach(quastion -> System.out.println(quastion.getTitle() + " -> " + quastion.getAnswers()));
    }
}
