package ru.otus.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * @author kimetsu - 02.07.2023 - 17:39
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Genre {
    @Id
    private Long id;
    private String title;
}
