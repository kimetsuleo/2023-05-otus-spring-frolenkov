package ru.otus.dao;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Component;
import ru.otus.domain.Question;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

@Component
public class QuestionDaoImpl implements QuestionDao {

    private final String path;

    public QuestionDaoImpl() {
        this.path = "question.csv";
    }

    @Override
    public List<Question> getAllQuestions() {
        try {
            return this.parseFromCsv(this.path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Question> parseFromCsv(String path) throws IOException {
        try (var inputStream = this.getClass().getClassLoader().getResourceAsStream(path)) {
            if (Objects.isNull(inputStream)) {
                throw new IllegalArgumentException("file not found!");
            }

            var inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            return new CsvToBeanBuilder<Question>(inputStreamReader)
                    .withSeparator(',')
                    .withType(Question.class)
                    .build()
                    .parse();
        }
    }
}
