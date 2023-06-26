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

    @CsvBindByName(column = "answers")
    private String answer;

    @CsvBindAndSplitByName(elementType = String.class, column = "options", splitOn = ";")
    private List<Answer> optionAnswers;

}
