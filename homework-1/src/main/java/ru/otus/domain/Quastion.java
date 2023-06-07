package ru.otus.domain;

import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindByName;

import java.util.List;

public class Quastion {
    @CsvBindByName(required = true)
    private String title;

    @CsvBindAndSplitByName(elementType = String.class, column = "answers", splitOn = ";")
    private List<Answer> answers;

    public Quastion() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public String getTitle() {
        return title;
    }
}
