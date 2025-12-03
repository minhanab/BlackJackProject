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
    public String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }
    
    
}
   private final User [] users;
   private  int userCount;
   private final PasswordValidator validator;

    public LoginManager() {
        this.users = new User[100];
        this.userCount = 0;
        this.validator = new PasswordValidator();
    }
    
    public void registerUser(String username, String password ){
        for (int i = 0; i < userCount; i++) {
            
            if(users[i].username.equals(username)) {
                System.out.println("Username already exists !");
                 
                return;
            }
        
        }
        
        if(!validator.validate(password)) {
            
            System.out.println(validator.getErrorMessage(password));
            return;
                
        }
        
        users[userCount] = new User(username, password);
        userCount++;
        System.out.println("Registration successful!");
        
        
    }
    
    public boolean login(String username, String password) {
        for (int i= 0; i < userCount; i++) {
            if (users[i].username.equals(username) && users[i].password.equals(password)) {
                return true;
            }
        }
        
        return false; 
}

    
   public String displayLoginMenu() {
       Scanner scanner= new Scanner(System.in);
       
       while(true) {
           
           System.out.println("\n --BLACKJACK LOGIN --");
           System.out.println("1. Login");
           System.out.println("2. Register");
           System.out.print("Choose (1 or 2): ");
           
           
           String choice = scanner.nextLine().trim();
           
           if(choice.equals("1")) {
               System.out.print("Username: ");
               String username= scanner.nextLine().trim();
               System.out.print("Password: ");
               String password= scanner.nextLine().trim();
               
               if(login(username, password)) {
                   System.out.println("Login successful");
                   
                   return username;
               }else {
                   System.out.println("Invalid username or password");
               }
           }
           
           else if (choice.equals("2")) {
               System.out.print("New username: ");
               String username = scanner.nextLine().trim();
               System.out.print("New password: ");
               String password = scanner.nextLine().trim();
               
               registerUser(username, password);
               
           }
           else {
               System.out.println("Invalid choice!");
           }
           
       }
   }
   
   


}