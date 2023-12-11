package com.skilldistillery.blackjack.entities;

import java.util.Scanner;

public class Player {

	private BlackjackHand hand;

	public Player() {
		hand = new BlackjackHand();
	}

	public void takeTurn(Deck deck, Scanner sc) {
		if (getHand().getHandValue() == 21) {
			System.out.println("Player has a Blackjack!");
			return;
		}

		while (true) {
			System.out.println("Do you want to Hit, Stand, or Quit? (H/S/Q)");
			String choice = sc.next();

			if ("H".equalsIgnoreCase(choice)) {
				hit(deck.dealCard());
				System.out.println(
						"Player's hand: " + getHand().getCards() + " (Value: " + getHand().getHandValue() + ")");
				if (getHand().getHandValue() > 21) {
					System.out.println("Player busts!");
					break;
				}
			} else if ("S".equalsIgnoreCase(choice)) {
				System.out.println("Player stands.");
				break;
			} else if ("Q".equalsIgnoreCase(choice)) {
				System.out.println("Quitting the game. Thanks for playing!");
				System.exit(0);
			} else {
				System.out.println("Invalid choice. Please enter H, S, or Q.");
			}
		}
	}

	public void hit(Card card) {
		hand.addCard(card);
	}

	public void stand() {

	}

	public BlackjackHand getHand() {
		return hand;
	}

}
