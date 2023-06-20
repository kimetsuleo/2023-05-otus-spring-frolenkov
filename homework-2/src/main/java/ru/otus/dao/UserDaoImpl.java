package ru.otus.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.domain.User;
import ru.otus.service.IOService;

@Component
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {

    private final IOService ioService;

    @Override
    public User registerUser() {
        User user = new User();

        this.ioService.print("Please enter your first name: ");
        user.setFirstName(this.ioService.readLine());

        this.ioService.print("Please enter your second name: ");
        user.setLastName(this.ioService.readLine());

        this.ioService.println("");

        return user;
    }
}
