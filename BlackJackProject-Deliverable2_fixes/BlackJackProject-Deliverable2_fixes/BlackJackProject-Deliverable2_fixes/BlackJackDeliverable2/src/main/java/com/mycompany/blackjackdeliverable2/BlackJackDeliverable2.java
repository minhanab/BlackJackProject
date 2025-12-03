/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.blackjackdeliverable2;

import java.util.Scanner;



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
        //Ask Professor tomorrow if this is needed for application purposes
        LoginManager loginManager = new LoginManager();
        String username = loginManager.displayLoginMenu();
        
        //initializing deck and player and shuffling the deck, and then as 
        //the round starts, the player takes 2 cards from the deck
         BlackJackDeck deck = BlackJackDeck.getInstance(); //creating a deck
        System.out.println("unshuffled deck: " + deck.getCards());
        deck.shuffle();
        System.out.println("Shuffled Deck: " + deck.getCards());
        
        
        //The Creation of Player and Dealer
        BlackJackPlayer player = new BlackJackPlayer(username);
        BlackJackDealer dealer = new BlackJackDealer("Dealer");
        
        //Initialzing Deck drawing two card to each
        player.getHand().drawCard(deck);
        player.getHand().drawCard(deck);
        dealer.getHand().drawCard(deck);
        dealer.getHand().drawCard(deck);
        
        
        
        System.out.println("\n== BLACKJACK ==");
        System.out.println("Player hand:" + player.getHand().getCards() + " = " 
                + player.getHand().getScore());
        System.out.println("Dealer showing: " + dealer.getHand().getCards().get(0));
        
        //Before any turn using a while loop if player/dealer hit 21 or higher busted, if player or dealer hits 21 , then either player wins or loses
        
        if (player.getHand().getScore()== 21) {
            System.out.println("Player has blackjack! Player wins!");
            return;
        }
        if (dealer.getHand().getScore()== 21) {
            System.out.println("Dealer has blackjack! Dealer wins!");
            return;
        }
        
        
        //Player's turn
        
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("\n Hit or Stand? (Hit/Stand): ");
            String choice = scanner.nextLine().trim().toLowerCase();
            
            if(choice.equals("hit")) {
                //error because this is instially creating a brand new deck due to boolean logic
                player.getHand().drawCard(deck);
                System.out.println("Player hand: " + player.getHand() .getCards()
                + player.getHand().getScore());
                  
               if(player.getHand().getScore() > 21) {
                   System.out.println("Player busted! Dealer wins!");
                   return;
               }
            } else if (choice.equals("Stay")) {
                break;
            }
        }
        
        //Dealer's turn
        // Same logic as player
        
        System.out.println("\nDealer's turn...");
        dealer.play();
        System.out.println("Dealer hand: " + dealer.getHand().getCards()+ " = " + dealer.getHand().getScore());
        
        int playerScore = player.getHand().getScore();
        int dealerScore = dealer.getHand().getScore();
        
        if (dealerScore > 21) {
            System.out.println("Dealer busted ! Player wins!");
            
        }else if (playerScore > dealerScore) {
            System.out.println("Dealer wins!");
        }else if (dealerScore > playerScore) {
            System.out.println("Dealer wins!");
        }else {
            System.out.println("Tie!");
        }
        //Duplication score and getCard
//        Hand playerHand = new Hand(deck);
//        System.out.println("Player Starting Hand: " + playerHand.getCards());
//        System.out.println("Player hand value: " + playerHand.getScore());
//        System.out.println("Deck after Player drew his cards" + deck.getCards());

    }
    
}
