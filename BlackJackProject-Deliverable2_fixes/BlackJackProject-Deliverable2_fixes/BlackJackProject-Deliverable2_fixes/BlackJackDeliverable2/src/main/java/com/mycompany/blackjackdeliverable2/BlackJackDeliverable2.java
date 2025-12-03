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
        deck.shuffle();
        System.out.println("\nDeck Shuffled");
        
        
        //The Creation of Player and Dealer
        BlackJackPlayer player = new BlackJackPlayer(username);
        BlackJackDealer dealer = new BlackJackDealer("Dealer");
        
        
        
        System.out.println("\n== BLACKJACK ==");
        System.out.println(username + "'s hand:" + player.getHand().getCards() + " = " 
                + player.getHand().getScore());
        System.out.println("Dealer showing: " + dealer.getHand().getCards().get(0));
        
        //Before any turn using a while loop if player/dealer hit 21 or higher busted, if player or dealer hits 21 , then either player wins or loses
        if (player.getHand().getScore()== 21 && dealer.getHand().getScore() == 21){
            System.out.println("Its a draw!");
        }
        else if (player.getHand().getScore()== 21) {
            System.out.println(username + " has blackjack! " + username + " wins!");
            return;
        }
        else if (dealer.getHand().getScore()== 21) {
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
                System.out.println(username + "'s hand: " + player.getHand() .getCards()
                + player.getHand().getScore());
                if(player.getHand().getScore() > 21) {

                //we need to make a clause that make it show your high score/low score when you have aces for clarity
                    if(player.getHand().getScore() > 21) {
                        System.out.println(username + " busted! Dealer wins!");
                        return;
                    }
                }
            }
            else if (choice.equals("stand")) {
                break;
            }
            else{
                System.out.println("Invalid input! Please enter 'Hit' or 'Stand'");
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
            System.out.println("Dealer busted ! " + username + " wins!");
            
        }else if (playerScore > dealerScore) {
            System.out.println(username + " wins!");
        }else if (dealerScore > playerScore) {
            System.out.println("Dealer wins!");
        }else {
            System.out.println("Its a draw!");
        }
        //Duplication score and getCard
//        Hand playerHand = new Hand(deck);
//        System.out.println("Player Starting Hand: " + playerHand.getCards());
//        System.out.println("Player hand value: " + playerHand.getScore());
//        System.out.println("Deck after Player drew his cards" + deck.getCards());

    }
    
}
