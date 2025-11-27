/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjackdeliverable2;

/**
 *
 * @author USER
 */
    //Do I even need this class??
    //Everything is done by Card.
    public class BlackJackCard extends Card {

        //makes the card 
        public BlackJackCard(Suit suit, Rank rank){
            super(suit, rank);
        }

        //removed getlowvalue and get high value methods because i added them 
        //in the enums since the enums are different classes now instead of all
        //being inside card.

        @Override
        public String toString() {
            return rank + " of " + suit;



        }
    
}

