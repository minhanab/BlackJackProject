/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjackdeliverable2;

import java.util.Scanner;

/**
 *
 * @author Naba Minhas
 * @author Sebastian
 */
public class BlackJackGame extends Game {

    private int playerPoints = 0;
    private int dealerPoints = 0;

    public BlackJackGame(String name) {
        super(name);
    }

    @Override
    public void play() {

        LoginManager loginManager = new LoginManager();
        String username = loginManager.displayLoginMenu();

        BlackJackDeck deck = BlackJackDeck.getInstance(); //creating a deck
        deck.shuffle();
        System.out.println("\nDeck Shuffled");

        //The Creation of Player and Dealer
        BlackJackPlayer player = new BlackJackPlayer(username);
        BlackJackDealer dealer = new BlackJackDealer("Dealer");


        System.out.println("\n== BLACKJACK ==");
        System.out.println("First one to 5 points wins the game!");
        while (playerPoints < 5 && dealerPoints < 5){
            player.getHand().clear();
            dealer.getHand().clear();
            
            player.getHand().drawCard(deck);
            dealer.getHand().drawCard(deck);
            player.getHand().drawCard(deck);
            dealer.getHand().drawCard(deck);
            
        boolean playerStands = false;// track if the player chosen to stand but as default its not determined
        boolean scoreShowed = false;
        
            System.out.println("\n-- NEW ROUND --");
            System.out.println("Current Score: " + username + ": " + playerPoints + " | Dealer: " + dealerPoints);
        
        System.out.println(username + "'s hand:" + player.getHand().getCards() + " = "
                + player.getHand().getScore());
        System.out.println("Dealer showing: [" + dealer.getHand().getCards().get(0) + " , Hidden Card]");

        //Before any turn using a while loop if player/dealer hit 21
        //or higher busted, if player or dealer hits 21 , then either player wins or loses and also uses the rounds points 
        if (player.getHand().getScore() == 21 || dealer.getHand().getScore() == 21) {
            roundWinner(player, dealer, username);
            scoreShowed = true;
            continue;
        }
        //Player's turn

        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            // only asks if the player hasn't stood or hit yet
            if (!playerStands) {
                System.out.print("\n Hit or Stand? (Hit/Stand): ");
                String choice = scanner.nextLine().trim().toLowerCase();

                if (choice.equals("hit")) {
                    player.getHand().drawCard(deck);
                    System.out.println(username + "'s hand: " + player.getHand().getCards()
                            + " = " + player.getHand().getScore());
                    if (player.getHand().getScore() > 21) {
                        roundWinner(player, dealer, username);
                        scoreShowed = true;
                        break;
                    }
                } else if (choice.equals("stand")) {
                    playerStands = true;
                    break;
                } else {
                    System.out.println("Invalid input! Please enter 'Hit' or 'Stand'");
                }
            }

            //Player stand and round moves to dealer next
            if (dealer.getHand().getScore() < 17) {
                dealer.getHand().drawCard(deck);
                System.out.println("Dealer hits...");
//                System.out.println("Dealer hits. Dealer hand:" + dealer.getHand().getCards() + " = " + dealer.getHand().getScore());
                if (dealer.getHand().getScore() > 21) {
                    roundWinner(player, dealer, username);
                    scoreShowed = true;
                    break;
                }
            } else if (playerStands) {
                //exits the loops if player has finished their stood and dealer has reached 17+ cards
                break;
            }
        }
           //Dealer finishes their hand until they reach 17+ cards and the winner will be determined
            while(dealer.getHand().getScore() < 17)  {
                dealer.getHand().drawCard(deck);
                System.out.println("Dealer hits. Dealer hand:" + dealer.getHand().getCards() + " = " + dealer.getHand().getScore());
                if (dealer.getHand().getScore() > 21) {
                    roundWinner(player, dealer, username);
                    scoreShowed = true;
                    break;
                }
            }
                  

         
        //Determine the winner
        if (!scoreShowed){
         roundWinner(player, dealer, username);
        }

    }
        declareWinner();
       

    }
    public void aces(BlackJackPlayer player, String username){
        System.out.println(username + "'s hand:" + player.getHand().getCards() + " = "
                + player.getHand().getScore());
        System.out.println(username + "'s hand:" + player.getHand().getCards() + " = "
                + player.getHand().getScore());
    }
// decalares the winner
    @Override
    public void declareWinner() {
        if (dealerPoints > playerPoints) {
            System.out.println("Dealer wins overall!");
        } else if (playerPoints > dealerPoints) {
            System.out.println("Player wins overall!");

        } else {
            System.out.println("Its a draw. Both win overall !");
        }

    }
//tracks number of rounds won 
    public void roundWinner(BlackJackPlayer player, BlackJackDealer dealer, String username) {

        int playerScore = player.getHand().getScore();
        int dealerScore = dealer.getHand().getScore();
        if (playerScore == 21 && dealerScore < 21){
            System.out.println(username + " has blackjack! " + username + " wins!");
            playerPoints++;
            
            System.out.println("Player Points: " + playerPoints);
            System.out.println("Dealer Points: " + dealerPoints);
        }
        else if (dealerScore == 21 && playerScore < 21){
            System.out.println("Dealer has blackjack! " + "Dealer wins!");
            dealerPoints++;
            
            System.out.println("Player Points: " + playerPoints);
            System.out.println("Dealer Points: " + dealerPoints);
        }
        if (playerScore > 21){
            System.out.println("Player busted ! " + "Dealer wins this round!");
            System.out.println(username + "'s hand: " + player.getHand().getCards()
                + " = " + player.getHand().getScore());
            System.out.println("Dealer's hand: " + dealer.getHand().getCards() + " = " +dealer.getHand().getScore());
            dealerPoints++;
            
            System.out.println("Player Points: " + playerPoints);
            System.out.println("Dealer Points: " + dealerPoints);
        }
        else if (dealerScore > 21) {
            System.out.println("Dealer busted ! " + username + " wins this round!");
            System.out.println(username + "'s hand: " + player.getHand().getCards()
                + " = " + player.getHand().getScore());
            System.out.println("Dealer's hand: " + dealer.getHand().getCards() + " = " +dealer.getHand().getScore());
            playerPoints++;
            
            System.out.println("Player Points: " + playerPoints);
            System.out.println("Dealer Points: " + dealerPoints);
        } else if (playerScore > dealerScore && playerScore < 21) {
            System.out.println(username + " wins this round!");
            System.out.println(username + "'s hand: " + player.getHand().getCards()
                + " = " + player.getHand().getScore());
            System.out.println("Dealer's hand: " + dealer.getHand().getCards() + " = " + dealer.getHand().getScore());
            playerPoints++;
            
            System.out.println("Player Points: " + playerPoints);
            System.out.println("Dealer Points: " + dealerPoints);
        } else if (dealerScore > playerScore && dealerScore < 21) {
            System.out.println("Dealer wins this round!");
            System.out.println(username + "'s hand: " + player.getHand().getCards()
                + " = " + player.getHand().getScore());
            System.out.println("Dealer's hand: " + dealer.getHand().getCards() + " = " + dealer.getHand().getScore());
            dealerPoints++;
            
            System.out.println("Player Points: " + playerPoints);
            System.out.println("Dealer Points: " + dealerPoints);
        } else {
            System.out.println("Its a draw for both this round!");
            System.out.println(username + "'s hand: " + player.getHand().getCards()
                + " = " + player.getHand().getScore());
            System.out.println("Dealer's hand: " + dealer.getHand().getCards() + " = " + dealer.getHand().getScore());
            
            System.out.println("Player Points: " + playerPoints);
            System.out.println("Dealer Points: " + dealerPoints);
        }

    }

}
