package ru.otus.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.domain.Book;
import ru.otus.service.AuthorService;
import ru.otus.service.BookService;
import ru.otus.service.GenreService;
import ru.otus.service.IOService;

import java.time.LocalDate;

/**
 * @author kimetsu - 09.07.2023 - 13:30
 */

@ShellComponent("Book CRUD commands")
@RequiredArgsConstructor
public class BookCommands {

    private final BookService bookService;

    private final AuthorService authorService;

    private final GenreService genreService;

    private final IOService ioService;

    @ShellMethod(value = "I print all books", key = "all-books")
    public void getAllBooks() {
        var books = bookService.getAll();
        books.forEach(book -> ioService.println(book.toString()));
    }

    @ShellMethod(value = "I print book by id", key = "get-book-by-id")
    public void getBookById(@ShellOption(value = "id") Long id) {
        Book book = bookService.getById(id);
        ioService.println(book.toString());
    }

    @ShellMethod(value = "I print book by id", key = "delete-book")
    public void deleteById(@ShellOption(value = "id") Long id) {
        boolean deleted = bookService.deleteById(id);
        ioService.println(Boolean.toString(deleted));
    }

    @ShellMethod(value = "I create new Book", key = "create")
    public void createNewBook(
            @ShellOption(value = {"-t", "--title"}) String title,
            @ShellOption(value = {"-a", "--author"}) Long authorId,
            @ShellOption(value = {"-g", "--genre"}) Long genreId,
            @ShellOption(value = {"-y", "--year"}, defaultValue = "2023") int year,
            @ShellOption(value = {"-m", "--month"}, defaultValue = "01") int month,
            @ShellOption(value = {"-d", "--day"}, defaultValue = "01") int day
    ) {
        Book book = Book.builder()
                .title(title)
                .author(authorService.getAuthorById(authorId))
                .genre(genreService.getGenreById(genreId))
                .publication_at(LocalDate.of(year, month, day))
                .build();

        bookService.insert(book);

        ioService.println("craete new book");
    }

}
