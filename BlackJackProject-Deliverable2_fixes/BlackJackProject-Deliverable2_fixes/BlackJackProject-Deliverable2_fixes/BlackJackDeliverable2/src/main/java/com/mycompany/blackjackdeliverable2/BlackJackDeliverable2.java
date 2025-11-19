/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.blackjackdeliverable2;

import java.util.List;

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
        BlackJackDeck deck = new BlackJackDeck();
        List<BlackJackCard> cardsInDeck = deck.getDeck();
        System.out.println("unshuffled deck: " );
        for (BlackJackCard card : cardsInDeck){
            System.out.println(card);
        }
        
        deck.shuffle(cardsInDeck);
        System.out.println("#########################");
        System.out.println("Shuffled deck");
        for(BlackJackCard card : cardsInDeck){
            System.out.println(card);
        }
    }
    
}
