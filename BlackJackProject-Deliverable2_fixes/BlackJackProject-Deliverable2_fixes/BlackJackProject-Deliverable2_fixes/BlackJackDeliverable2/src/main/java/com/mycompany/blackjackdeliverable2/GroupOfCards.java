/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package com.mycompany.blackjackdeliverable2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
//group of cards for both the hand and the deck
public abstract class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards;
    private int size;//the size of the grouping

    //initializing the specific arrayList for the player / deck when called
    //size of the hand/deck needed to differentiate
    public GroupOfCards(int size) {
        this.size = size;
        this.cards = new ArrayList<>();
    }
    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    //returns the array so we can print the cards in hand
    public ArrayList<Card> getCards() {
        return cards;
    }


    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }

}//end class
