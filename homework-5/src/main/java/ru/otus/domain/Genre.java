package ru.otus.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author kimetsu - 02.07.2023 - 17:39
 */

@Data
public class Genre {
    @Id
    private Long id;
    private String title;
}
