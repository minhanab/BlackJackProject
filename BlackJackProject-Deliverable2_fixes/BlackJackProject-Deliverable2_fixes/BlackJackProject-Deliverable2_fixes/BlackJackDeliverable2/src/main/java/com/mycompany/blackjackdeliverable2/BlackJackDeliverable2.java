/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.blackjackdeliverable2;



/**
 *
 * @author spmar
 */
public class BlackJackDeliverable2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //initializing deck and player and shuffling the deck, and then as 
        //the round starts, the player takes 2 cards from the deck
        BlackJackDeck deck = new BlackJackDeck();
        deck.createDeck();
        System.out.println("unshuffled deck: " + deck.getCards());
        deck.shuffle();
        System.out.println("Shuffled Deck: " + deck.getCards());
        
        Hand playerHand = new Hand(deck);
        System.out.println("Player Starting Hand: " + playerHand.getCards());
        System.out.println("Player hand value: " + playerHand.getScore());
        System.out.println("Deck after Player drew his cards" + deck.getCards());

    }
    
}
