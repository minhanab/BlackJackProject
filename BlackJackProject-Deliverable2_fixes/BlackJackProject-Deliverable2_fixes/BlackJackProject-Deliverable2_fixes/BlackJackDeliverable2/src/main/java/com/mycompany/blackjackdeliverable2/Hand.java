/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjackdeliverable2;


/**
 *
 * @author spmar
 */
public class Hand extends GroupOfCards{

    //hand of the player, starts with 2 size arraylist
    //then draws 2 cards
    public Hand(BlackJackDeck deck){
        super(2);
    }
    
    //checker for the score of the hand to see if the player busted.
    //need a highscore and low score to see if the player has over 21 with an ace
    //but might not have over 21 with the ace since it has both a value of 1 and 11
    //I might have to seperate the get highscore count and get low score count
    //since maybe we want to show which is which, instead of deciding for the
    //player
    public int getHighScore(){
        int highScore = 0;
        for (Card card: this.getCards()){
            highScore += card.rank.getHighValue();
        }
        return highScore;
    }
    public int getLowScore(){
        int lowScore = 0;
        for (Card card: this.getCards()){
            lowScore += card.rank.getLowValue();
        }
        return lowScore;
    }
    public int getScore(){
        int highScoreCount = 0;
        int lowScoreCount = 0;

        for(Card card : this.getCards()){
            highScoreCount += card.rank.getHighValue();
            lowScoreCount += card.rank.getLowValue();
        }
        if (highScoreCount >21){
            return lowScoreCount;
        }
        else{
            return highScoreCount;
        }

    }
    //draw a card. takes the card being removed from the blackjackdeck card , (prob should make it into the group of cards class
    // when deck removes one card, it returns that card , so draw card will take that returned value and add it to our hand
    public void drawCard(BlackJackDeck deck){
        Card card = deck.dealCard();
        if (card != null){
            this.getCards().add(card);
        }
    }
    
    public void clear(){
            this.getCards().clear();
    }
    
    
}
