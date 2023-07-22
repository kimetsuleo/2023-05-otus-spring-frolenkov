package ru.otus.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.domain.Book;
import ru.otus.service.IOService;

/**
 * @author kimetsu - 22.07.2023 - 14:05
 */

@Component
@RequiredArgsConstructor
public class BookConverter {

    private final IOService ioService;

    public void getBookNameWithIdAndGenreAndAuthor(Book book) {

        this.ioService.println("""
                        ID: %d
                        TITLE: %s
                        AUTHOR: %s
                        GENRE: %s
                        """.formatted(
                        book.getId(),
                        book.getTitle(),
                        book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName(),
                        book.getGenre().getTitle()
                )
        );
    }

}
