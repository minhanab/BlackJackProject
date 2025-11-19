/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjackdeliverable2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author spmar
 */
public class BlackJackDeck  {
    private BlackJackCard.Suit suit;
    private BlackJackCard.Rank rank;
    private List<BlackJackCard> deck;
    
    public BlackJackDeck(){
        this.deck = createDeck();
    }
    public BlackJackDeck(BlackJackCard.Suit suit, BlackJackCard.Rank rank){
        this.suit = suit;
        this.rank = rank;
    }
    
    public List<BlackJackCard> createDeck(){
        List<BlackJackCard> cards = new ArrayList<>();
        for (BlackJackCard.Suit s: BlackJackCard.Suit.values()){
            for (BlackJackCard.Rank r: BlackJackCard.Rank.values()){
                cards.add(new BlackJackCard(s, r));
            }
        }
        return cards;
    }
    public void shuffle(List<BlackJackCard> deck){
        Collections.shuffle(deck);
    }

    public List<BlackJackCard> getDeck(){
        return deck;
    }
    
}
