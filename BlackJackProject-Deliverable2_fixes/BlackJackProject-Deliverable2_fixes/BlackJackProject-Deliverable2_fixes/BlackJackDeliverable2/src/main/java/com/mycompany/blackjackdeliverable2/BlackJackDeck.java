/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjackdeliverable2;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author spmar
 */
public class BlackJackDeck extends GroupOfCards {
    
    //creates the array for the deck and tells group of cards that its 52 cards
    public BlackJackDeck(){
        super(52);
    }
    //populates the deck made in group of cards through for loops to make the deck
    //of 52 cards.
    public void createDeck(){
        for (Suit s: Suit.values()){
            for (Rank r: Rank.values()){
                this.getCards().add(new BlackJackCard(s, r));
            }
        }
    }
    //removes 1 card if the deck isnt empty, and then returs the value of that card
    //for the hand method drawCard to take that value and add it to the deck.
    public Card dealCard(){
        if (!this.getCards().isEmpty()){
            return this.getCards().remove(0);
        }
        return null;
    }
    //shuffle the cards, so the deck can be shuffled
    public void shuffle() {
        Collections.shuffle(this.getCards());
    }

}
