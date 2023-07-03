package ru.otus.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * @author kimetsu - 02.07.2023 - 17:38
 */

@Data
public class Author {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private Date dof;
}
