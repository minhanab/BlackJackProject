/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjackdeliverable2;

/**
 *
 * @author Naba minhas
 * @author Sebastien-Paul Martineau
 */
public class BlackJackDealer extends BlackJackPlayer {

    private Hand hand;
    
    public BlackJackDealer(String name) {
        super(name);
        this.hand = new Hand(BlackJackDeck.getInstance());
    }
    
     @Override
    public void play() {
        BlackJackDeck deck = BlackJackDeck.getInstance();
        while(this.hand.getScore() < 17) {
            this.hand.drawCard(deck);
        }
        
        
    }

    public Hand getHand() {
        return hand;
    }
    
    
    
}
