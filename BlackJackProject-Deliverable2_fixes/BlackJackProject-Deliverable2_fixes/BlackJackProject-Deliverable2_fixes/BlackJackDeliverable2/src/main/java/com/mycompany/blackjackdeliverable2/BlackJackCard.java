/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjackdeliverable2;

/**
 *
 * @author USER
 */
public class BlackJackCard extends Card {
    
    private Suit suit;
    private Rank rank;
    
    public BlackJackCard(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }
    public enum Suit{ 
            HEARTS, DIAMONDS, CLUBS, SPADES 
    }
    
    public enum Rank { 
        TWO("2", 2, 2), THREE("3",3 , 3), FOUR("4", 4, 4), FIVE("5",5,5), SIX("6", 6, 6), SEVEN("7", 7, 7),EIGHT("8",8,8), NINE("9",9,9), 
        TEN("10", 10, 10),JACK("J", 10, 10), QUEEN("Q", 10, 10), KING("K", 10, 10), ACE("A", 1, 11);  
    
        private final String label;
        private final int lowValue;
        private final int highValue;

        Rank(String label, int lowValue, int highValue) {
            this.label = label;
            this.lowValue = lowValue; 
            this.highValue = highValue;
        }
        
   
//      public int getValue() {
//        return value;
//      }

    };
    
    
    public String getRankLabel(){
        return this.rank.label;
    }
    public int getRankLowValue(){
        return this.rank.lowValue;
    }
    public int getRankHighValue(){
        return this.rank.highValue;
    }
    public Suit getSuit(){
        return this.suit;
    }
    
//    
//    
//    public BlackJackCard(Suit suit, Rank rank) {
//        this.suit = suit;
//        this.rank = rank;
//    }
//
//    public Suit getSuit() {
//        return suit;
//    }
//
//    public Rank getRank() {
//        return rank;
//    }
//  
//    public int getValue() {
//        return rank.getValue();
//    }
//    

   
    @Override
    public String toString() {
        return rank + "of" + suit;
    
     
    
    }
    
}

