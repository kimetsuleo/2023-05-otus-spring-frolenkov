package ru.otus.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.dao.UserDao;
import ru.otus.dao.UserDaoImpl;
import ru.otus.domain.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @author kimetsu - 18.06.2023 - 13:50
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("User service test")
public class UserDaoTest {

    @Test
    @DisplayName("register user")
    public void testRegisterUser() {
        String firstName = "John";
        String lastName = "Doe";

        // Mock IOService
        IOService ioServiceMock = mock(IOService.class);
        when(ioServiceMock.readLine()).thenReturn(firstName, lastName);

        UserDao dao = new UserDaoImpl(ioServiceMock);
        User user = dao.registerUser();

        assertEquals(firstName, user.getFirstName());
        assertEquals(lastName, user.getLastName());

        verify(ioServiceMock).print("Please enter your first name: ");
        verify(ioServiceMock).print("Please enter your second name: ");
        // verify(ioServiceMock).println(""); // Optional, not necessary
    }

}
