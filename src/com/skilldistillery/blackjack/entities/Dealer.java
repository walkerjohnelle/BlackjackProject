package com.skilldistillery.blackjack.entities;

public class Dealer extends Player {

	private Deck deck;

	public Dealer(Deck deck) {
		this.deck = deck;
	}

	public void takeTurn() {
		revealHoleCard();

		if (getHand().getHandValue() == 21) {
			System.out.println("Dealer has a Blackjack!");
			return;
		}

		decideToHit();
	}

	private void decideToHit() {
		while (toHitOrNot()) {
			hit(deck.dealCard());
			System.out.println("Dealer's hand: " + getHand().getCards());
		}
	}

	public boolean toHitOrNot() {
		return getHand().getHandValue() < 17;
	}

	public void revealHoleCard() {
		System.out.println("Dealer's hold card: " + getHand().getCards().get(1));
	}

	public void shuffle() {
		deck.shuffle();
	}
}
