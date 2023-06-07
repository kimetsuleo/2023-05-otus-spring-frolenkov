package ru.otus.utils;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

public class CSVUtil {

    public <T> List<T> parseFromCsv(Class<? extends T> clazz, String path) {
        return new CsvToBeanBuilder<T>(this.reader(path))
                .withSeparator(',')
                .withType(clazz)
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
