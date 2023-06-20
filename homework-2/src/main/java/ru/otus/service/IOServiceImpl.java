package ru.otus.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

/**
 * @author kimetsu - 19.06.2023 - 22:46
 */
@Service
public class IOServiceImpl implements IOService {
    @Override
    public String readLine() {
        return new Scanner(System.in).nextLine();
    }

    @Override
    public void println(String str) {
        System.out.println(str);
    }

    @Override
    public void print(String str) {
        System.out.print(str);
    }
}
