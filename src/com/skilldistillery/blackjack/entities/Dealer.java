package com.skilldistillery.blackjack.entities;

public class Dealer extends Player {

	private Deck deck;

	public Dealer(Deck deck) {
		this.deck = deck;
	}

	public boolean toHitOrNot() {
		return getHand().getHandValue() < 17;
	}

	public void revealHoleCard() {
		System.out.println("Dealer's hold card: " + getHand().getCards().get(1));
	}

	public void decideToHit() {
		while (toHitOrNot()) {
			hit(deck.dealCard());
			System.out.println("Dealer's hand: " + getHand().getCards());

		}

	}

	public void shuffle() {
		deck.shuffle();
	}
}
