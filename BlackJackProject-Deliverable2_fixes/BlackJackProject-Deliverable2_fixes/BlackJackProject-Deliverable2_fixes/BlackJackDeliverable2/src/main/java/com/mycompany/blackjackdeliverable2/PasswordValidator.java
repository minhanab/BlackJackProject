/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjackdeliverable2;

/**
 *
 * @author USER
 */
public class PasswordValidator {
    
    public boolean validate (String password) {
        if(password == null)   {
            
            return false;
        } 
        
        if(password.length() < 9) {
            return false;
        }
        
        if(!password.matches(".*[^A-Za-z0-9].*")) {
            return false;
        }
        
        if(!password.matches(".*[A-Z].*")) {
            return false;
        }
           
        
        if(!password.matches(".*[a-z].*")) {
            return false;
        }
        
        if(!password.matches(".*[0-9].*")) {
            return false;
            
        }
        
        return true;
        
    }
    
     public String getErrorMessage(String password) {
          if(password == null || password.isEmpty()) {
              return "Password cannot be empty!";
          }
         
          if(password.length() < 9) {
              return "Password must be at leas 9 characters!";
          }
          
          if(!password.matches(".*[A-Z].*")) {
              return "Password must be have uppercase letter!";
          }
          
          if(!password.matches(",*[a-z].*")) {
              return "Password must have a lowercase letter";
              
          }
          
          if(!password.matches(".*[0-9].*")) {
              return "Password must have a number";
          }
          
          if(!password.matches(".*[^A-Za-z0-9].*")) {
              
              return "Password must have special character!";
          }
          
          return "Invalid password!";
         
     }
     
        
}
