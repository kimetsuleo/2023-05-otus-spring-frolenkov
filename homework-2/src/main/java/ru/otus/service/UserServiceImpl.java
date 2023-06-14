package ru.otus.service;

import org.springframework.stereotype.Service;
import ru.otus.domain.User;

import java.util.Scanner;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void registerUser() {
        Scanner scanner = new Scanner(System.in);

        User user = new User();

        System.out.print("Please enter your first name: ");
        user.setFirstName(scanner.next());

        System.out.print("Please enter your second name: ");
        user.setLastName(scanner.next());

    }
}
