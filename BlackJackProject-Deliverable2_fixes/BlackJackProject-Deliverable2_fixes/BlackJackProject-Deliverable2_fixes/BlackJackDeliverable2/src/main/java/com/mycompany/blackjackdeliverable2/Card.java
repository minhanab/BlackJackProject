/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package com.mycompany.blackjackdeliverable2;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 */
public abstract class Card {
    //default modifier for child classes

    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    protected Suit suit;
    protected Rank rank;
    
    //creates a card of suit ? and rank ? 
    // which is used in the for loop to create the deck
    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }
    //getters for the cards
    public Suit getSuit(){
        return this.suit;
    }
    public Rank getRank(){
        return this.rank;
    }
        public String getRankLabel(Rank rank){
        return rank.getLabel();
    }
    
//  I used to have these methods, but realized if i want to do non blackjack 
//  centric games, then they wont want to implement ranklabel, low balue high value
//  public abstract int getRankLowValue(Rank rank);
//  public abstract int getRankHighValue(Rank rank);


    
    @Override
    public abstract String toString();

}
