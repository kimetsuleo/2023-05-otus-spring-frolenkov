package ru.otus.domain;

import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @CsvBindByName(required = true)
    private String title;

    @CsvBindAndSplitByName(elementType = String.class, column = "answers", splitOn = ";")
    private List<Answer> answers;

}
