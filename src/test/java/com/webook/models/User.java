package com.webook.models;

import com.github.javafaker.Faker;
import lombok.*;
import java.lang.*;
import java.util.Random;

@Data
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;

    public User() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String email = firstName + faker.number().digits(2) + "@gmail.com";
        this.firstName = firstName;
        this.lastName = faker.name().lastName();
        this.email = email;
        this.phoneNumber = "505" + faker.phoneNumber().subscriberNumber(6);
        this.password = "Test123!";
    }
}
