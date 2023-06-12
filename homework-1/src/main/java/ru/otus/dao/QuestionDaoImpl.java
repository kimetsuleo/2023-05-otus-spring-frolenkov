package ru.otus.dao;

import com.opencsv.bean.CsvToBeanBuilder;
import ru.otus.domain.Question;

import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

public class QuestionDaoImpl implements QuestionDao {

    private final String path;

    public QuestionDaoImpl(String path) {
        this.path = path;
    }

    @Override
    public List<Question> getAllQuestions() {
        return this.parseFromCsv(this.path);
    }

    private List<Question> parseFromCsv(String path) {
        return new CsvToBeanBuilder<Question>(this.reader(path))
                .withSeparator(',')
                .withType(Question.class)
                .build()
                .parse();
    }

    private Reader reader(String path) {
        var inputStream = this.getClass().getClassLoader().getResourceAsStream(path);

        if (Objects.isNull(inputStream)) {
            throw new IllegalArgumentException("file not found!");
        }

        return new InputStreamReader(inputStream, StandardCharsets.UTF_8);
    }
}
