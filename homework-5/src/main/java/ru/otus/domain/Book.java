package ru.otus.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * @author kimetsu - 02.07.2023 - 17:38
 */

@Data
public class Book {

    @Id
    private Long id;
    private String title;
    private Author author;
    private Genre genres;
    private Date publication_at;
}
