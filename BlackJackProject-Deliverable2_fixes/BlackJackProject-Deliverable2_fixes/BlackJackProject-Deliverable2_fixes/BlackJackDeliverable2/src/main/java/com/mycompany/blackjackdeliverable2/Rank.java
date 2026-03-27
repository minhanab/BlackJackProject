/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.blackjackdeliverable2;

/**
 *
 * @author Sebastien-Paul
 * @author naba
 */
//Rank enum to see what number is on the card
//need a high and low value for the aces, so we can get a dynamic number and
//check if the number is under 21 for both values
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
    public String getLabel(){
        return this.label;
    }
    public int getLowValue(){
        return this.lowValue;
    }
    public int getHighValue(){
        return this.highValue;
    }
        
}

