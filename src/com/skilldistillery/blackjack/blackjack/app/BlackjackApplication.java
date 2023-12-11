package com.skilldistillery.blackjack.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackjackHand;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApplication {

	private Scanner sc = new Scanner(System.in);
	private Deck deck = new Deck();
	private BlackjackHand blackjackHand = new BlackjackHand();

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

			player.takeTurn(deck, sc);

			if (player.getHand().getHandValue() > 21) {
				System.out.println("Player busts!");
			}

			dealer.takeTurn();

			blackjackHand.determineWinner(player, dealer);

			checkDeckStatus();

			player.getHand().clearHand();
			dealer.getHand().clearHand();

		} while (true);
	}

	private void startBlackjack(Dealer dealer, Player player) {
		dealer.shuffle();
		player.hit(deck.dealCard());
		dealer.hit(deck.dealCard());
		player.hit(deck.dealCard());
		dealer.hit(deck.dealCard());
	}

	private void displayInitialHands(Dealer dealer, Player player) {
		System.out.println(
				"Player's hand: " + player.getHand().getCards() + " (Value: " + player.getHand().getHandValue() + ")");
		System.out.println("Dealer's hand: " + dealer.getHand().getCards().get(0) + " [Hidden]");
	}

	private void checkDeckStatus() {
		if (deck.checkDeckSize() <= 13) {
			System.out.println("Deck is almost empty. Do you want to play again? (Y/N)");
			String playAgainChoice = sc.next();

			if ("Y".equalsIgnoreCase(playAgainChoice)) {
				System.out.println("Shuffling the deck and starting a new game...");
				deck = new Deck();
				deck.shuffle();
			} else {
				System.out.println("Thanks for playing! Exiting the game.");
				System.exit(0);
			}
		}
	}
}
