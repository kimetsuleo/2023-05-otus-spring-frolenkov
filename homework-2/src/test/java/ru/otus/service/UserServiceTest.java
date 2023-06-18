package ru.otus.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.otus.domain.User;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

/**
 * @author kimetsu - 18.06.2023 - 13:50
 */
@DisplayName("User service test")
public class UserServiceTest {

    @Test
    public void testUserRegistration() {
        // Arrange
        String input = "John\nDoe\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        User expectedUser = new User();
        expectedUser.setFirstName("John");
        expectedUser.setLastName("Doe");

        Mockito.mock(Scanner.class);

        UserService userService = new UserServiceImpl();

        // Act
        User actualUser = userService.registerUser();

        // Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedUser.getFirstName(), actualUser.getFirstName()),
                () -> Assertions.assertEquals(expectedUser.getLastName(), actualUser.getLastName())
        );
    }

}
