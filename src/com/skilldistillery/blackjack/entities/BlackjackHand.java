package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand {

	public int getHandValue() {
		int value = 0;
		int numAces = 0;

		for (Card card : cards) {
	        if (card != null) {
	            value += card.getValue();
	            if (card.getRank() == Rank.ACE) {
	                numAces++;
	            }
	        }
	    }

	    while (numAces > 0 && value > 21) {
	        value -= 10;
	        numAces--;
	    }

	    return value;
	}
	
	public void determineWinner(Player player, Dealer dealer) {
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