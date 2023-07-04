package ru.otus.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

/**
 * @author kimetsu - 02.07.2023 - 17:38
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    private Long id;
    private String title;
    private Author author;
    private Genre genre;
    private LocalDate publication_at;
}
