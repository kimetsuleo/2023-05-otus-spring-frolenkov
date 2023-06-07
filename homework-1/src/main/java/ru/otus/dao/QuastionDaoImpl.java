package ru.otus.dao;

import ru.otus.domain.Quastion;
import ru.otus.utils.CSVUtil;

import java.util.List;

public class QuastionDaoImpl implements QuastionDao {

    private final String path;

    private final CSVUtil util;

    public QuastionDaoImpl(String path, CSVUtil util) {
        this.path = path;
        this.util = util;
    }

    @Override
    public List<Quastion> getAllQuastions() {
        return this.util.parseFromCsv(Quastion.class, this.path);
    }
}
