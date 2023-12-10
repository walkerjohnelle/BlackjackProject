package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand {

	public int getHandValue() {
		int value = 0;
		int numAces = 0;

		for (Card card : cards) {
			value += card.getValue();

			if (card.getRank() == Rank.ACE) {
				numAces++;
			}
		}

		while (numAces > 0 && value > 21) {
			value -= 10;
			numAces--;
		}
		return value;
	}
}
