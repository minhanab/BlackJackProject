/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjackdeliverable2;

/**
 *
 * @author USE
 * 
**/

public class BlackJackPlayer extends Player {
    
   protected Hand hand;
    public BlackJackPlayer(String name) {
        super(name);
    }

    @Override
    public void play() {
        
    }
   
    public Hand getHand() {
        return hand;
    }
    
  
}
