package com.mycompany.blackjackdeliverable2;

import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Naba Minhas
 * @author Sebastian
 */
public class LoginManager {

    public class User {

        public String username;

        public User(String username) {
            this.username = username;

        }

    }
    private final User[] users;
    private int userCount;

    public LoginManager() {
        this.users = new User[100];
        this.userCount = 0;

    }

    public void registerUser(String username) {
        for (int i = 0; i < userCount; i++) {

            if (users[i].username.equals(username)) {
                System.out.println("Username already exists !");

                return;
            }

        }

        users[userCount] = new User(username);
        userCount++;
        System.out.println("Registration successful!");

    }

    public boolean login(String username) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].username.equals(username)) {
                return true;
            }
        }

        return false;
    }

    public String displayLoginMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a username");

        String username = scanner.nextLine().trim();

        return username;

    }

}
