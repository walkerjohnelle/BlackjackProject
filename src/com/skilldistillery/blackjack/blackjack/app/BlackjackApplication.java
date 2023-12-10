package com.skilldistillery.blackjack.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApplication {

	private Scanner sc = new Scanner(System.in);
	private Deck deck = new Deck();

	public static void main(String[] args) {

		BlackjackApplication app = new BlackjackApplication();
		app.run();
	}

	public void run() {
		Player player = new Player();
		Dealer dealer = new Dealer(deck);

		do {
			startBlackjack(dealer, player);

			displayInitialHands(dealer, player);

			// Player's turn
			while (true) {
			    System.out.println("Do you want to Hit, Stand, or Quit? (H/S/Q)");
			    String choice = sc.next();

			    if ("H".equalsIgnoreCase(choice)) {
			        player.hit(deck.dealCard());
			        System.out.println("Player's hand: " + player.getHand().getCards() + " (Value: "
			                + player.getHand().getHandValue() + ")");

			        if (player.getHand().getHandValue() > 21) {
			            System.out.println("Player busts!");
			            break;  // Exit the loop if the player busts
			        }
			    } else if ("S".equalsIgnoreCase(choice)) {
			        System.out.println("Player stands.");
			        break;  // Exit the loop if the player stands
			    } else if ("Q".equalsIgnoreCase(choice)) {
			        System.out.println("Quitting the game. Thanks for playing!");
			        return;
			    } else {
			        System.out.println("Invalid choice. Please enter H, S, or Q.");
			    }
			}

			// Check if the player busted (outside the loop)
			if (player.getHand().getHandValue() > 21) {
			    System.out.println("Player busts!");
			}


			// Dealer's turn
			dealer.revealHoleCard();
			while (dealer.toHitOrNot()) {
			    dealer.hit(deck.dealCard());
			    System.out.println("Dealer's hand: " + dealer.getHand().getCards() + " (Value: "
			            + dealer.getHand().getHandValue() + ")");

			    if (dealer.getHand().getHandValue() > 21) {
			        System.out.println("Dealer busts!");
			        // Continue to determining the winner
			        break;
			    }
			}

			// Determine the winner
			determineWinner(player, dealer);

			// Check if the deck is almost empty
			if (deck.checkDeckSize() < 10) {
				System.out.println("Deck is almost empty. Do you want to play again? (Y/N)");
				String playAgainChoice = sc.next();

				if ("Y".equalsIgnoreCase(playAgainChoice)) {
					System.out.println("Shuffling the deck and starting a new game...");
					deck = new Deck();
					deck.shuffle();
				} else {
					System.out.println("Thanks for playing! Exiting the game.");
					return;
				}
			}

			// Reset hands for the next round
			player.getHand().clearHand();
			dealer.getHand().clearHand();

		} while (true);
	}

	public void startBlackjack(Dealer dealer, Player player) {
		dealer.shuffle();
		player.hit(deck.dealCard());
		dealer.hit(deck.dealCard());
		player.hit(deck.dealCard());
		dealer.hit(deck.dealCard());
	}

	public void displayInitialHands(Dealer dealer, Player player) {
		System.out.println(
				"Player's hand: " + player.getHand().getCards() + " (Value: " + player.getHand().getHandValue() + ")");
		System.out.println("Dealer's hand: " + dealer.getHand().getCards().get(0) + " [Hidden]");
	}

	private void determineWinner(Player player, Dealer dealer) {
	    int playerValue = player.getHand().getHandValue();
	    int dealerValue = dealer.getHand().getHandValue();

		System.out.println("Player's hand: " + player.getHand().getCards() + " (Value: " + playerValue + ")");
		System.out.println("Dealer's hand: " + dealer.getHand().getCards() + " (Value: " + dealerValue + ")");

		if ((playerValue > 21 && dealerValue > 21) || playerValue == dealerValue) {
			System.out.println("It's a push!");
		} else if (playerValue > 21) {
			System.out.println("Player busts! Dealer wins.");
		} else if (dealerValue > 21) {
			System.out.println("Dealer busts! Player wins!");
		} else if (playerValue == 21 || (dealerValue < 21 && dealerValue < playerValue)) {
	        System.out.println("Player wins!!!");
	    } else {
	        System.out.println("Dealer wins.");
	    }
	}

}
